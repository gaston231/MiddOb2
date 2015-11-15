package com;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.jms.Connection;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.client.epuerto.EPuertoConfirmacionRequest;
import com.client.epuerto.EPuertoPedidoRequest;
import com.client.epuerto.IAmazoniaEPuerto;
import com.client.epuerto.IAmazoniaEPuertoService;
import com.client.pagosya.IAmazoniaPagosYa;
import com.client.pagosya.IAmazoniaPagosYaService;
import com.client.pagosya.PagosYaRequest;
import com.client.pagosya.PagosYaResponse;
import com.client.stock.Pedido;
import com.client.stock.ResultadoPedido;
import com.client.stock.Stock;
import com.client.stock.StockService;

import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;



@WebService(targetNamespace = "http://com/", portName = "AmazoniaServicePort", serviceName = "AmazoniaServiceService")
public class AmazoniaService implements IAmazoniaService {
	
	private static int idReservaEPuerto = 1;
	private static int codigoResultado = 100;
	
	@WebMethod(operationName = "recepcionOrdenes", action = "urn:RecepcionOrdenes")
	public String recepcionOrdenes(@WebParam(name = "arg0") DataOrden orden){
		double monto = 0;
		
		// Enviar pedidos a Stock
		StockService stock_ser = new StockService();
		Stock stock = stock_ser.getStockPort();
		
		List<Pedido> productos = new ArrayList<Pedido>();
		for (DataProducto pedido : orden.getProductos()) {
			Pedido p = new Pedido();
			p.setCantidad(pedido.getCantidad());
			p.setIdProducto(pedido.getIdProducto());
			productos.add(p);
			monto = monto + (pedido.getCantidad()*pedido.getPrecio());
		}
		
		
		ResultadoPedido res_stock = stock.reservaDeProductos(productos);
		System.out.println("ResultadoPedido: "+res_stock.getCodigo()+"-"+res_stock.getDescripcion()+"-"+res_stock.getIdReserva());
		
		// Si falla o no tiene algun producto
		if (!res_stock.getCodigo().toLowerCase().equals("ok")){
			// --- Enviar pedido a EPuerto
			IAmazoniaEPuertoService epuerto_ser = new IAmazoniaEPuertoService();
			IAmazoniaEPuerto epuerto = epuerto_ser.getIAmazoniaEPuertoPort();
			for (DataProducto pedido : orden.getProductos()) {
			
				EPuertoPedidoRequest ped = new EPuertoPedidoRequest();
				ped.setCantidad(pedido.getCantidad());
				ped.setIdCompra(String.valueOf(orden.getIdCompra()));
				ped.setIdProducto(pedido.getIdProducto());
				epuerto.recibirPedido(ped);
				
			}
			
			// Confirmar EPuerto
			EPuertoConfirmacionRequest conf = new EPuertoConfirmacionRequest();
			conf.setCodigoResultado(codigoResultado);
			conf.setDescripcion("Confirmado");
			conf.setIdCompra(String.valueOf(orden.getIdCompra()));
			conf.setIdReserva(String.valueOf(idReservaEPuerto));
			epuerto.confirmarOrden(conf);
			
			idReservaEPuerto++;
			codigoResultado++;
		}
		
		// Enviar el pago a PagosYa
		IAmazoniaPagosYaService pagosya_ser = new IAmazoniaPagosYaService();
		IAmazoniaPagosYa pagosya = pagosya_ser.getIAmazoniaPagosYaPort();
		
		
		PagosYaRequest pago = new PagosYaRequest();
		pago.setFechaHora("16-11-2015 19:45");
		pago.setIdCompra(Long.valueOf(orden.getIdCompra()));
		pago.setMonto(monto);
		pago.setNroTarjeta(String.valueOf(orden.getNroTarjeta()));
		
		PagosYaResponse res_pagosya = pagosya.realizarPago(pago);
		
		// Si hay error en el pago
		if (Long.valueOf(res_pagosya.getIdPago()) == -1){
			// --- Cancelar pedido en EPuerto
			// --- Cancelar pedido en Stock
			
			try {
				String cancelacion = "";
				if (res_stock.getIdReserva() == 0){
					cancelacion = "{\"anulacionEPuerto\":{\"arg0\":\""+idReservaEPuerto+"\"}}";
					enviarMensajeJMS(cancelacion);
				} else {
					cancelacion = "{\"AnulacionDeReserva\":{\"arg0\":"+res_stock.getIdReserva()+"}}";
					enviarMensajeJMS(cancelacion);
				}
				
				
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Error al enviar mensaje JMS";
			}
				
		}
		
		
		// Responder resultado
		return "Orden recibida";
	}
	
	private void enviarMensajeJMS(String texto) throws JMSException{
		// Create a ConnectionFactory
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        // Create a Connection
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // Create a Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Create the destination (Topic or Queue)
        Destination destination = session.createTopic("CancelacionAmazonia");

        // Create a MessageProducer from the Session to the Topic or Queue
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        
        TextMessage message = session.createTextMessage(texto);
    	producer.send(message);
    	
    	// Clean up
        session.close();
        connection.close();
		

	}
	
}

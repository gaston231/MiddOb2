package com.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService(targetNamespace = "http://stock.com/", portName = "StockPort", serviceName = "StockService")
public class Stock {	
	
	@WebMethod(operationName = "ReservaDeProductos", action = "urn:ReservaDeProductos")
	public ResultadoPedido ReservaDeProductos(List<Pedido> lista ){		
		return RealizarPedido(lista );
	}
	
	@WebMethod(operationName = "AnulacionDeReserva", action = "urn:AnulacionDeReserva")
	public ResultadoAnulacion AnulacionDeReserva(long IdReserva){		
		return AnularReserva(IdReserva);
	}
	
	private long ultimaReserva;	
	private Map<Long,Integer> inventario;
	private Map<Long,Reserva> reservas;
	
	
	
	private Stock(){
		ultimaReserva = 0;
		reservas = new HashMap<Long,Reserva>();
		inventario = new HashMap<Long,Integer>();
		inventario.put((long) 1,100);
		inventario.put((long) 2,100);
		inventario.put((long) 3,100);
		inventario.put((long) 4,100);
		inventario.put((long) 5,100);		
	}
	
	private ResultadoPedido RealizarPedido(List<Pedido> lista ){
		ResultadoPedido resultado  = new ResultadoPedido();
		
		Reserva r = new Reserva();
		
		List<Pedido> pedido = new ArrayList<Pedido>();
		boolean ok = true;
		long idFaltante=0;
		
		for(Pedido p : lista){			
			if(inventario.keySet().contains(p.getIdProducto())){
				int cant = inventario.get(p.getIdProducto());
				if(cant >= p.getCantidad()){
					Pedido nuevo = new Pedido();
					nuevo.setCantidad(p.getCantidad());
					nuevo.setIdProducto(p.getIdProducto());
					pedido.add(nuevo);
				}else {
					ok = false;
					idFaltante = p.getIdProducto();
					break;
				}
			}else{
				ok = false;
				idFaltante = p.getIdProducto();
				break;
			}
			
		}
		
		if(ok){
			for(Pedido p : pedido){
				 int cantidad =inventario.get(p.getIdProducto());
				 inventario.put(p.getIdProducto(), cantidad - p.getCantidad());
			}
			ultimaReserva++;
			r.setIdReserva(ultimaReserva); 
			r.setArticulos(pedido);
			reservas.put(ultimaReserva, r);
			resultado.setCodigo("OK");
			resultado.setDescripcion("Pedido Realizado");
			resultado.setIdReserva(ultimaReserva);
			
		}else{
			resultado.setCodigo("Error");
			resultado.setDescripcion("No hay suficientes" + String.valueOf(idFaltante));
			resultado.setIdReserva(0);
		}	
		
		return resultado;
	}
	
	private ResultadoAnulacion AnularReserva(long idReserva){
		ResultadoAnulacion resultado = new ResultadoAnulacion();
		Reserva r  = reservas.get(idReserva);
		
		if(r!= null){
			
			List<Pedido> pedido = r.getArticulos();
			for(Pedido p:pedido){
				int cant = inventario.get(p.getIdProducto());
				inventario.put(p.getIdProducto(), cant + p.getCantidad());
			}
			reservas.remove(idReserva);
 			resultado.setCodigo("OK");
			resultado.setDescripcion("Reserva Anulada");
			
		}else{
			resultado.setCodigo("Error");
			resultado.setDescripcion("No se encontro la reserva " + String.valueOf(idReserva));
		}
		
		return resultado;
	}

}

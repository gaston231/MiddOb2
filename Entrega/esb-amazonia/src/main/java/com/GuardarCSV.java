package com;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;

public class GuardarCSV {

	public String recibirPedido(String payload){
		JSONObject pedido = new JSONObject(payload).getJSONObject("ns2:recibirPedido").getJSONObject("arg0");
		
		String idCompra = pedido.getString("idCompra");
		long idProducto = pedido.getLong("idProducto");
		System.out.println("IdProducto: "+idProducto);
		int cantidad = pedido.getInt("cantidad");
		
		String nombreArchivo = "C:\\Middleware\\testdir\\recepcion\\"+idCompra+"-"+String.valueOf(idProducto)+".csv";
        String texto = "identificadorCompra;identificadorProducto;cantidad\n";
        texto += idCompra+";"+idProducto+";"+cantidad;
        try{
            FileWriter fwriter = new FileWriter(nombreArchivo);
            //fwriter.write('\ufeff'); //si no se escribe esto, excel no muestra bien el texto con tildes
            fwriter.write(texto);
            fwriter.flush();
            fwriter.close();
        }catch (IOException e){
            Logger.getLogger(GuardarCSV.class.getName()).log(Level.SEVERE, null, e);
//            return new EPuertoResponse("ERROR al guardar archivo en recepcion");
            return "ERROR al guardar archivo en recepcion";
        }
	
//		return new EPuertoResponse("OK");
        return "OK";
	}
	
	public EPuertoResponse confirmarOrden(String payload){
		JSONObject pedido = new JSONObject(payload).getJSONObject("ns2:confirmarOrden").getJSONObject("arg0");
		
		String idCompra = pedido.getString("idCompra");
		String idReserva = pedido.getString("idReserva");
		int codigoResultado = pedido.getInt("codigoResultado");
		String descripcion = pedido.getString("descripcion");
		
		String nombreArchivo = "C:\\Middleware\\testdir\\confirmar\\"+idCompra+".csv";
        String texto = "identificadorCompra;identificadorReserva;codigo;descripcion\n";
        texto += idCompra+";"+idReserva+";"+codigoResultado+";"+descripcion;
        try{
            FileWriter fwriter = new FileWriter(nombreArchivo);
            //fwriter.write('\ufeff'); //si no se escribe esto, excel no muestra bien el texto con tildes
            fwriter.write(texto);
            fwriter.flush();
            fwriter.close();
        }catch (IOException e){
            Logger.getLogger(GuardarCSV.class.getName()).log(Level.SEVERE, null, e);
            return new EPuertoResponse("ERROR al guardar archivo en confirmar");
        }
	
		return new EPuertoResponse("OK");
	}
	
	public EPuertoResponse cancelarOrden(String payload){
		JSONObject pedido = new JSONObject(payload).getJSONObject("anulacionEPuerto");
		
		String idReserva = pedido.getString("arg0");
		
		String nombreArchivo = "C:\\Middleware\\testdir\\anular\\"+idReserva+".csv";
        String texto = "identificadorReserva\n";
        texto += idReserva;
        try{
            FileWriter fwriter = new FileWriter(nombreArchivo);
            //fwriter.write('\ufeff'); //si no se escribe esto, excel no muestra bien el texto con tildes
            fwriter.write(texto);
            fwriter.flush();
            fwriter.close();
        }catch (IOException e){
            Logger.getLogger(GuardarCSV.class.getName()).log(Level.SEVERE, null, e);
            return new EPuertoResponse("ERROR al guardar archivo en confirmar");
        }
	
		return new EPuertoResponse("OK");
	}
	
	
	public EPuertoResponse noSoportada(){
		return new EPuertoResponse("Operación No soportada");
	}
	
	
	public String envelope(String entrada){
		return "<recibirPedidoResponse>"+entrada+"</recibirPedidoResponse>";
	}
}

package com;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;

public class GuardarCSV {

	public String recibirPedido(String payload){
		JSONObject pedido = new JSONObject(payload).getJSONObject("com:recibirPedido").getJSONObject("arg0");
		
		String idCompra = pedido.getString("idCompra");
		long idProducto = pedido.getLong("idProducto");
		int cantidad = pedido.getInt("cantidad");
		
		String nombreArchivo = "C:\\Middleware\\testdir\\recepcion\\"+idCompra+".csv";
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
            return "ERROR al guardar archivo en recepcion";
        }
	
		return "OK";
	}
	
	public String confirmarOrden(String payload){
		JSONObject pedido = new JSONObject(payload).getJSONObject("com:confirmarOrden").getJSONObject("arg0");
		
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
            return "ERROR al guardar archivo en confirmar";
        }
	
		return "OK";
	}
	
	public String cancelarOrden(String payload){
		JSONObject pedido = new JSONObject(payload).getJSONObject("anulacionEPuerto");
		
		String idReserva = pedido.getString("idReserva");
		
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
            return "ERROR al guardar archivo en confirmar";
        }
	
		return "OK";
	}
	
	
	public String noSoportada(){
		return "Operación No soportada";
	}
	
}

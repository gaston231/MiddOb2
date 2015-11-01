package ws;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.StatusType;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.ClientResponse.Status;

@Path("/pago")
public class Pago {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response realizarPago(String msj){
		// REALIZAR PAGO EN PAGOSYA
		// Entrada: JSON con los pagos a realizar
		// Salida: JSON con la confirmación de los pagos
		// Error: Codigos de error utilizados por REST
		
		// Parseo la entrada
		JSONObject solicitud = new JSONObject(msj);
		
		long idCompra = solicitud.getLong("idCompra");
		String nroTarjeta = solicitud.getString("nroTarjeta");
		double monto = solicitud.getDouble("monto");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		LocalDate fechaHora = LocalDate.parse(solicitud.getString("fechaHora"), formatter);
		
		// LOGICA DE PAGOSYA
		// nroTarjeta 10000 a 99999 sino (404 not found)
		// monto 1 a 999999 sino (400 monto excedido)
		//
		
		
		JSONObject salida = new JSONObject();
		
		// nroTarjeta solo numeros
		if (!Pattern.compile("^[0-9]*$").matcher(nroTarjeta).matches()){
			salida.put("idPago", "-1");
			salida.put("mensaje", "ERROR: nroTarjeta no válido");
			return Response.status(Status.NOT_FOUND).entity(salida.toString()).build();
		}
		
		salida.put("idPago", "14566");
		salida.put("mensaje", "OK");
		return Response.status(Status.OK).entity(salida.toString()).build();
	}
	
	// ARRAY DE JSON
//	{"pagos":[
//	          {"idCompra":"3472", "nroTarjeta":"121423541231", "monto":"348", "fechaHora":"19-10-2015 14:45"},
//	          {"idCompra":"2474", "nroTarjeta":"78954457", "monto":"4567", "fechaHora":"19-10-2015 14:52"},
//	          {"idCompra":"2475", "nroTarjeta":"465222", "monto":"65", "fechaHora":"19-10-2015 09:21"}
//	      ]}
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public String realizarPago(String msj){
//		// REALIZAR PAGO EN PAGOSYA
//		// Entrada: JSON con los pagos a realizar
//		// Salida: JSON con la confirmación de los pagos
//		// Error: Codigos de error utilizados por REST
//		
//		// Parseo la entrada
//		JSONObject entrada = new JSONObject(msj);
//		JSONArray entradaArray = entrada.getJSONArray("pagos");
//		
//		String stringSalida;
//		JSONObject salida = new JSONObject();
//		salida.put("name", "confirmacion");
//		JSONArray salidaArray = new JSONArray();
//		
//		// Recorro todas las solicitudes de pago
//		for (int i = 0; i < entradaArray.length(); i++) {
//			JSONObject solicitud = entradaArray.getJSONObject(i);
//			
//			long idCompra = solicitud.getLong("idCompra");
//			String nroTarjeta = solicitud.getString("nroTarjeta");
//			double monto = solicitud.getDouble("monto");
//			
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//			LocalDate fechaHora = LocalDate.parse(solicitud.getString("fechaHora"), formatter);
//			
//			// LOGICA DE PAGOSYA
//			// nroTarjeta 10000 a 99999 sino (404 not found)
//			// monto 1 a 999999 sino (400 monto excedido)
//			//
//			
//			JSONObject salidaItem = new JSONObject();
//			salidaItem.put("idPago", "2015_"+nroTarjeta);
//			salidaArray.put(salidaItem);
//
//			salida.put("pago", salidaArray);
//
//		}
//		    
//		
//		stringSalida = salida.toString();
//		
//		return stringSalida;
//
//		//return Response.status(Status.OK).entity(output).build();
//	}
}

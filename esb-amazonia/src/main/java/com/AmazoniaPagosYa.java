package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.jws.WebService;

import org.json.JSONObject;

@WebService(endpointInterface = "com.AmazoniaPagosYa",serviceName = "AmazoniaPagosYa")
public class AmazoniaPagosYa implements IAmazoniaPagosYa{

	public PagosYaResponse realizarPago(PagosYaRequest request){
		JSONObject solicitud = new JSONObject();
		solicitud.put("idCompra", request.getIdCompra());
		solicitud.put("nroTarjeta", request.getNroTarjeta());
		solicitud.put("monto", request.getMonto());
		solicitud.put("fechaHora", request.getFechaHora());
		PagosYaResponse respuesta = new PagosYaResponse();
		
		try {

			URL url = new URL("http://localhost:8080/PagosYa/REST/pago");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
	
			
			OutputStream os = conn.getOutputStream();
			os.write(solicitud.toString().getBytes());
			os.flush();
	
			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("ERROR: Codigo: "
					+ conn.getResponseCode() + " Mensaje: " + conn.getResponseMessage());
			}
	
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
	
			
			String salida = "";
			String output;
			while ((output = br.readLine()) != null) {
				salida = salida + output;
			}
	
			JSONObject json_salida = new JSONObject(salida);
			
			respuesta.setIdPago(json_salida.getJSONObject("PagosYa").getLong("idPago"));
			respuesta.setMensaje(json_salida.getJSONObject("PagosYa").getString("mensaje"));
	
			conn.disconnect();
			
		  } catch (MalformedURLException e) {
	
			e.printStackTrace();
	
		  } catch (IOException e) {
	
			e.printStackTrace();
	
		 }
	
		return respuesta;
		
	}
}

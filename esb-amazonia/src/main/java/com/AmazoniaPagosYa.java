package com;

import javax.jws.WebService;

import org.json.JSONObject;

@WebService(endpointInterface = "com.AmazoniaPagosYa",serviceName = "AmazoniaPagosYa")
public class AmazoniaPagosYa implements IAmazoniaPagosYa{

	public String realizarPago(long idCompra, String nroTarjeta, double monto, String fechaHora){
		JSONObject solicitud = new JSONObject();
		solicitud.put("idCompra", idCompra);
		solicitud.put("nroTarjeta", nroTarjeta);
		solicitud.put("monto", monto);
		solicitud.put("fechaHora", fechaHora);
		return solicitud.toString();		
	}
}

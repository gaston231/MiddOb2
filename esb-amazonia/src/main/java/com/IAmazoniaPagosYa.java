package com;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IAmazoniaPagosYa {
	String realizarPago(@WebParam(name = "idCompra") long idCompra, @WebParam(name = "nroTarjeta") String nroTarjeta, @WebParam(name = "monto") double monto, @WebParam(name = "fechaHora") String fechaHora);
}

package com;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService(targetNamespace = "http://com/", portName = "RecepcionOrdenesPort", serviceName = "RecepcionOrdenesService")
public class RecepcionOrdenes {

	@WebMethod
	public String recibirOrdenCompra(@WebParam(name = "idCompra") String idCompra, @WebParam(name = "nroTarjeta") long nroTarjeta, @WebParam(name = "productos") List<DataProducto> productos){
		System.out.println("Inicia el metodo recibirOrdenCompra");
		System.out.println(idCompra);
		System.out.println(nroTarjeta);
		return "Pedido recibido";
	}
}

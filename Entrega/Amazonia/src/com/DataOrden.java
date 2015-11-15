package com;

import java.util.List;

public class DataOrden {

	private String idCompra;
	private long nroTarjeta;
	private List<DataProducto> productos;
	
	public String getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(String idCompra) {
		this.idCompra = idCompra;
	}
	public long getNroTarjeta() {
		return nroTarjeta;
	}
	public void setNroTarjeta(long nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}
	public List<DataProducto> getProductos() {
		return productos;
	}
	public void setProductos(List<DataProducto> productos) {
		this.productos = productos;
	}
	
	
}

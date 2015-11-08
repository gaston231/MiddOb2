package com;

public class PagosYaRequest {

	private long idCompra;
	private String nroTarjeta;
	private double monto;
	private String fechaHora;
	
	
	public long getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(long idCompra) {
		this.idCompra = idCompra;
	}
	public String getNroTarjeta() {
		return nroTarjeta;
	}
	public void setNroTarjeta(String nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
	
}

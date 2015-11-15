package com.stock;

import java.util.List;

public class Reserva {
	
	private long idReserva;
	private List<Pedido> articulos;
	
	public long getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}
	public List<Pedido> getArticulos() {
		return articulos;
	}
	public void setArticulos(List<Pedido> articulos) {
		this.articulos = articulos;
	}
}

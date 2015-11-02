package com.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;



@WebService(targetNamespace = "http://stock.com/", portName = "StockPort", serviceName = "StockService")
public class Stock {	
	
	public ResultadoPedido ReservaDeProductos(List<Pedido> lista ){		
		return RealizarPedido(lista );
	}
	
	public ResultadoAnulacion AnulacionDeReserva(long IdReserva){		
		return AnularReserva(IdReserva);
	}
	
	private long ultimaReserva;	
	private Map<Long,Integer> inventario;
	private Map<Long,Reserva> reservas;
	
	
	
	private Stock(){
		ultimaReserva = 0;
		reservas = new HashMap<Long,Reserva>();
		inventario = new HashMap<Long,Integer>();
		inventario.put((long) 1,100);
		inventario.put((long) 2,100);
		inventario.put((long) 3,100);
		inventario.put((long) 4,100);
		inventario.put((long) 5,100);		
	}
	
	private ResultadoPedido RealizarPedido(List<Pedido> lista ){
		ResultadoPedido resultado  = new ResultadoPedido();
		
		Reserva r = new Reserva();
		
		List<Pedido> pedido = new ArrayList<Pedido>();
		boolean ok = true;
		long idFaltante=0;
		
		for(Pedido p : lista){			
			if(inventario.keySet().contains(p.IdProducto)){
				int cant = inventario.get(p.IdProducto);
				if(cant >= p.Cantidad){
					Pedido nuevo = new Pedido();
					nuevo.setCantidad(p.Cantidad);
					nuevo.setIdProducto(p.IdProducto);
					pedido.add(nuevo);
				}else {
					ok = false;
					idFaltante = p.IdProducto;
					break;
				}
			}else{
				ok = false;
				idFaltante = p.IdProducto;
				break;
			}
			
		}
		
		if(ok){
			for(Pedido p : pedido){
				 int cantidad =inventario.get(p.IdProducto);
				 inventario.put(p.IdProducto, cantidad - p.Cantidad);
			}
			ultimaReserva++;
			r.IdReserva = ultimaReserva;
			r.Articulos = pedido;
			reservas.put(ultimaReserva, r);
			resultado.Codigo ="OK";
			resultado.Descripcion = "Pedido Realizado";
			resultado.IdReserva = ultimaReserva;
			
		}else{
			resultado.Codigo ="Error";
			resultado.Descripcion = "No hay suficientes" + String.valueOf(idFaltante);
		}	
		
		return resultado;
	}
	
	private ResultadoAnulacion AnularReserva(long idReserva){
		ResultadoAnulacion resultado = new ResultadoAnulacion();
		Reserva r  = reservas.get(idReserva);
		
		if(r!= null){
			
			List<Pedido> pedido = r.Articulos;
			for(Pedido p:pedido){
				int cant = inventario.get(p.IdProducto);
				inventario.put(p.IdProducto, cant + p.Cantidad);
			}
			reservas.remove(idReserva);
 			resultado.Codigo = "OK";
			resultado.Descripcion = "Reserva Anulada";
			
		}else{
			resultado.Codigo = "Error";
			resultado.Descripcion = "No se encontro la reserva " + String.valueOf(idReserva);
		}
		
		return resultado;
	}

}

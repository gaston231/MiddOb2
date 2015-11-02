package ws;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.json.JSONObject;
import com.sun.jersey.api.client.ClientResponse.Status;

@Path("/pago")
public class Pago {
	
	private static long idPago = 1000;
	private static final Logger log = Logger.getLogger(Pago.class.getName() );
	
	@Path("hola")
	@GET
	public Response saludar(){
		log.info("SALUDO PagosYa");
		return Response.status(Status.OK).entity("API REST PagosYa").build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response realizarPago(String msj){
		// REALIZAR PAGO EN PAGOSYA
		// Entrada: JSON con los pagos a realizar
		// Salida: JSON con la confirmación de los pagos
		// Error: Codigos de error utilizados por REST
		
		// Parseo la entrada
		JSONObject solicitud = new JSONObject(msj);	
		JSONObject salida = new JSONObject();
		
		
		log.info("SOLICITUD PAGO: " + solicitud.toString());
		
		try{
			// nroTarjeta solo numeros de 1000 a 9999
			String nroTarjeta = solicitud.getString("nroTarjeta");
			if (!Pattern.compile("^[0-9]*$").matcher(nroTarjeta).matches()){
				salida.put("idPago", "-1");
				salida.put("mensaje", "ERROR: nroTarjeta no válido");
				return Response.status(Status.BAD_REQUEST).entity(salida.toString()).build();
			}
			// nroTarjeta valores de 1000 a 9999
			if ((nroTarjeta.compareTo("1000") < 0) || (nroTarjeta.compareTo("9999") > 0)){
				salida.put("idPago", "-1");
				salida.put("mensaje", "ERROR: nroTarjeta no encontrado");
				return Response.status(Status.NOT_FOUND).entity(salida.toString()).build();
			}
		} catch (Exception e){
			salida.put("idPago", "-1");
			salida.put("mensaje", "ERROR: nroTarjeta no válido");
			return Response.status(Status.BAD_REQUEST).entity(salida.toString()).build();
		}
		
		// monto solo numeros de 0 a 999999
		try{
			double monto = solicitud.getDouble("monto");
			if ((monto < 0) || (monto > 999999)){
				salida.put("idPago", "-1");
				salida.put("mensaje", "ERROR: monto máximo excedido");
				log.info("ERROR PAGO");
				return Response.status(Status.BAD_REQUEST).entity(salida.toString()).build();
			}
		} catch (Exception e){
			salida.put("idPago", "-1");
			salida.put("mensaje", "ERROR: monto no válido");
			log.info("ERROR PAGO");
			return Response.status(Status.BAD_REQUEST).entity(salida.toString()).build();
		}
		
		// idCompra solo numeros de 100000 a 999999
		try{
			long idCompra = solicitud.getLong("idCompra");
			if ((idCompra < 100000) || (idCompra > 999999)){
				salida.put("idPago", "-1");
				salida.put("mensaje", "ERROR: idCompra no permitido");
				log.info("ERROR PAGO");
				return Response.status(Status.BAD_REQUEST).entity(salida.toString()).build();
			}
		} catch (Exception e){
			salida.put("idPago", "-1");
			salida.put("mensaje", "ERROR: idCompra no válido");
			log.info("ERROR PAGO");
			return Response.status(Status.BAD_REQUEST).entity(salida.toString()).build();
		}
		
		// fechaHora menor a 31/12/2015 23:59
		try{
			String stringHora = solicitud.getString("fechaHora");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			LocalDate fechaHora = LocalDate.parse(stringHora, formatter);
			if (fechaHora.getYear() > 2015){
				salida.put("idPago", "-1");
				salida.put("mensaje", "ERROR: fechaHora mayor a la permitida");
				log.info("ERROR PAGO");
				return Response.status(Status.BAD_REQUEST).entity(salida.toString()).build();
			}
		} catch (Exception e){
			salida.put("idPago", "-1");
			salida.put("mensaje", "ERROR: fechaHora con formato no válido");
			log.info("ERROR PAGO");
			return Response.status(Status.BAD_REQUEST).entity(salida.toString()).build();
		}
		
		// PARAMETROS CORRECTOS, GENERO NUMERO DE PAGO
		salida.put("idPago", idPago);
		salida.put("mensaje", "OK");
		
		log.info("CONFIRMACION PAGO: Identificador pago " + idPago);
		
		idPago++;
		return Response.status(Status.OK).entity(salida.toString()).build();
	}
}

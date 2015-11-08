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
	@POST
	public String saludar(String nombre){
		log.info("SALUDO PagosYa");
		//return Response.status(Status.BAD_REQUEST).entity("API REST PagosYa").build();
		return "Saludos desde REST PagosYa para "+nombre;
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
		JSONObject item = new JSONObject();
		
		log.info("SOLICITUD PAGO: " + solicitud.toString());
		
		try{
			// nroTarjeta solo numeros de 1000 a 9999
			String nroTarjeta = solicitud.getString("nroTarjeta");
			if (!Pattern.compile("^[0-9]*$").matcher(nroTarjeta).matches()){
				item.put("idPago", "-1");
				item.put("mensaje", "ERROR: nroTarjeta no válido");
				log.info("ERROR PAGO");
				return Response.status(Status.BAD_REQUEST).entity(item.toString()).build();
			}
			// nroTarjeta valores de 1000 a 9999
			if ((Long.valueOf(nroTarjeta) < 1000) || (Long.valueOf(nroTarjeta) > 9999)){
				item.put("idPago", "-1");
				item.put("mensaje", "ERROR: nroTarjeta no encontrado");
				log.info("ERROR PAGO");
				return Response.status(Status.NOT_FOUND).entity(item.toString()).build();
			}
		} catch (Exception e){
			item.put("idPago", "-1");
			item.put("mensaje", "ERROR: nroTarjeta no válido");
			log.info("ERROR PAGO");
			return Response.status(Status.BAD_REQUEST).entity(item.toString()).build();
		}
		
		// monto solo numeros de 0 a 999999
		try{
			double monto = solicitud.getDouble("monto");
			if ((monto < 0) || (monto > 999999)){
				item.put("idPago", "-1");
				item.put("mensaje", "ERROR: monto máximo excedido");
				log.info("ERROR PAGO");
				return Response.status(Status.BAD_REQUEST).entity(item.toString()).build();
			}
		} catch (Exception e){
			item.put("idPago", "-1");
			item.put("mensaje", "ERROR: monto no válido");
			log.info("ERROR PAGO");
			return Response.status(Status.BAD_REQUEST).entity(item.toString()).build();
		}
		
		// idCompra solo numeros de 100000 a 999999
		try{
			long idCompra = solicitud.getLong("idCompra");
			if ((idCompra < 100000) || (idCompra > 999999)){
				item.put("idPago", "-1");
				item.put("mensaje", "ERROR: idCompra no permitido");
				log.info("ERROR PAGO");
				return Response.status(Status.BAD_REQUEST).entity(item.toString()).build();
			}
		} catch (Exception e){
			item.put("idPago", "-1");
			item.put("mensaje", "ERROR: idCompra no válido");
			log.info("ERROR PAGO");
			return Response.status(Status.BAD_REQUEST).entity(item.toString()).build();
		}
		
		// fechaHora menor a 31/12/2015 23:59
		try{
			String stringHora = solicitud.getString("fechaHora");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			LocalDate fechaHora = LocalDate.parse(stringHora, formatter);
			if (fechaHora.getYear() > 2015){
				item.put("idPago", "-1");
				item.put("mensaje", "ERROR: fechaHora mayor a la permitida");
				log.info("ERROR PAGO");
				return Response.status(Status.BAD_REQUEST).entity(item.toString()).build();
			}
		} catch (Exception e){
			item.put("idPago", "-1");
			item.put("mensaje", "ERROR: fechaHora con formato no válido");
			log.info("ERROR PAGO");
			return Response.status(Status.BAD_REQUEST).entity(item.toString()).build();
		}
		
		// PARAMETROS CORRECTOS, GENERO NUMERO DE PAGO
		item.put("idPago", idPago);
		item.put("mensaje", "OK");
		
		salida.put("PagosYa", item);
		log.info("CONFIRMACION PAGO: " + salida.toString());
		
		idPago++;
		return Response.status(Status.CREATED).entity(salida.toString()).build();
	}
}

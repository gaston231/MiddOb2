
package com.client.stock;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.17
 * 2015-11-15T13:06:23.365-02:00
 * Generated source version: 2.7.17
 * 
 */
public final class Stock_StockPort_Client {

    private static final QName SERVICE_NAME = new QName("http://stock.com/", "StockService");

    private Stock_StockPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = StockService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        StockService ss = new StockService(wsdlURL, SERVICE_NAME);
        Stock port = ss.getStockPort();  
        
        {
        System.out.println("Invoking anulacionDeReserva...");
        long _anulacionDeReserva_arg0 = 3681152036446600045l;
        com.client.stock.ResultadoAnulacion _anulacionDeReserva__return = port.anulacionDeReserva(_anulacionDeReserva_arg0);
        System.out.println("anulacionDeReserva.result=" + _anulacionDeReserva__return);


        }
        {
        System.out.println("Invoking reservaDeProductos...");
        java.util.List<com.client.stock.Pedido> _reservaDeProductos_arg0 = new java.util.ArrayList<com.client.stock.Pedido>();
        com.client.stock.Pedido _reservaDeProductos_arg0Val1 = new com.client.stock.Pedido();
        _reservaDeProductos_arg0Val1.setCantidad(413352141);
        _reservaDeProductos_arg0Val1.setIdProducto(2626028675143359657l);
        _reservaDeProductos_arg0.add(_reservaDeProductos_arg0Val1);
        com.client.stock.ResultadoPedido _reservaDeProductos__return = port.reservaDeProductos(_reservaDeProductos_arg0);
        System.out.println("reservaDeProductos.result=" + _reservaDeProductos__return);


        }

        System.exit(0);
    }

}

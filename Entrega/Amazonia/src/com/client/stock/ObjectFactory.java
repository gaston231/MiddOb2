
package com.client.stock;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.client.stock package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AnulacionDeReserva_QNAME = new QName("http://stock.com/", "AnulacionDeReserva");
    private final static QName _AnulacionDeReservaResponse_QNAME = new QName("http://stock.com/", "AnulacionDeReservaResponse");
    private final static QName _ReservaDeProductos_QNAME = new QName("http://stock.com/", "ReservaDeProductos");
    private final static QName _ReservaDeProductosResponse_QNAME = new QName("http://stock.com/", "ReservaDeProductosResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.client.stock
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReservaDeProductos }
     * 
     */
    public ReservaDeProductos createReservaDeProductos() {
        return new ReservaDeProductos();
    }

    /**
     * Create an instance of {@link ReservaDeProductosResponse }
     * 
     */
    public ReservaDeProductosResponse createReservaDeProductosResponse() {
        return new ReservaDeProductosResponse();
    }

    /**
     * Create an instance of {@link AnulacionDeReserva }
     * 
     */
    public AnulacionDeReserva createAnulacionDeReserva() {
        return new AnulacionDeReserva();
    }

    /**
     * Create an instance of {@link AnulacionDeReservaResponse }
     * 
     */
    public AnulacionDeReservaResponse createAnulacionDeReservaResponse() {
        return new AnulacionDeReservaResponse();
    }

    /**
     * Create an instance of {@link ResultadoAnulacion }
     * 
     */
    public ResultadoAnulacion createResultadoAnulacion() {
        return new ResultadoAnulacion();
    }

    /**
     * Create an instance of {@link Pedido }
     * 
     */
    public Pedido createPedido() {
        return new Pedido();
    }

    /**
     * Create an instance of {@link ResultadoPedido }
     * 
     */
    public ResultadoPedido createResultadoPedido() {
        return new ResultadoPedido();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnulacionDeReserva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stock.com/", name = "AnulacionDeReserva")
    public JAXBElement<AnulacionDeReserva> createAnulacionDeReserva(AnulacionDeReserva value) {
        return new JAXBElement<AnulacionDeReserva>(_AnulacionDeReserva_QNAME, AnulacionDeReserva.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnulacionDeReservaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stock.com/", name = "AnulacionDeReservaResponse")
    public JAXBElement<AnulacionDeReservaResponse> createAnulacionDeReservaResponse(AnulacionDeReservaResponse value) {
        return new JAXBElement<AnulacionDeReservaResponse>(_AnulacionDeReservaResponse_QNAME, AnulacionDeReservaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservaDeProductos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stock.com/", name = "ReservaDeProductos")
    public JAXBElement<ReservaDeProductos> createReservaDeProductos(ReservaDeProductos value) {
        return new JAXBElement<ReservaDeProductos>(_ReservaDeProductos_QNAME, ReservaDeProductos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservaDeProductosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stock.com/", name = "ReservaDeProductosResponse")
    public JAXBElement<ReservaDeProductosResponse> createReservaDeProductosResponse(ReservaDeProductosResponse value) {
        return new JAXBElement<ReservaDeProductosResponse>(_ReservaDeProductosResponse_QNAME, ReservaDeProductosResponse.class, null, value);
    }

}

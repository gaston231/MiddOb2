
package com.client.epuerto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.client.epuerto package. 
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

    private final static QName _RecibirPedido_QNAME = new QName("http://com/", "recibirPedido");
    private final static QName _ConfirmarOrdenResponse_QNAME = new QName("http://com/", "confirmarOrdenResponse");
    private final static QName _ConfirmarOrden_QNAME = new QName("http://com/", "confirmarOrden");
    private final static QName _RecibirPedidoResponse_QNAME = new QName("http://com/", "recibirPedidoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.client.epuerto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RecibirPedido }
     * 
     */
    public RecibirPedido createRecibirPedido() {
        return new RecibirPedido();
    }

    /**
     * Create an instance of {@link RecibirPedidoResponse }
     * 
     */
    public RecibirPedidoResponse createRecibirPedidoResponse() {
        return new RecibirPedidoResponse();
    }

    /**
     * Create an instance of {@link ConfirmarOrden }
     * 
     */
    public ConfirmarOrden createConfirmarOrden() {
        return new ConfirmarOrden();
    }

    /**
     * Create an instance of {@link ConfirmarOrdenResponse }
     * 
     */
    public ConfirmarOrdenResponse createConfirmarOrdenResponse() {
        return new ConfirmarOrdenResponse();
    }

    /**
     * Create an instance of {@link EPuertoResponse }
     * 
     */
    public EPuertoResponse createEPuertoResponse() {
        return new EPuertoResponse();
    }

    /**
     * Create an instance of {@link EPuertoConfirmacionRequest }
     * 
     */
    public EPuertoConfirmacionRequest createEPuertoConfirmacionRequest() {
        return new EPuertoConfirmacionRequest();
    }

    /**
     * Create an instance of {@link EPuertoPedidoRequest }
     * 
     */
    public EPuertoPedidoRequest createEPuertoPedidoRequest() {
        return new EPuertoPedidoRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecibirPedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com/", name = "recibirPedido")
    public JAXBElement<RecibirPedido> createRecibirPedido(RecibirPedido value) {
        return new JAXBElement<RecibirPedido>(_RecibirPedido_QNAME, RecibirPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmarOrdenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com/", name = "confirmarOrdenResponse")
    public JAXBElement<ConfirmarOrdenResponse> createConfirmarOrdenResponse(ConfirmarOrdenResponse value) {
        return new JAXBElement<ConfirmarOrdenResponse>(_ConfirmarOrdenResponse_QNAME, ConfirmarOrdenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmarOrden }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com/", name = "confirmarOrden")
    public JAXBElement<ConfirmarOrden> createConfirmarOrden(ConfirmarOrden value) {
        return new JAXBElement<ConfirmarOrden>(_ConfirmarOrden_QNAME, ConfirmarOrden.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecibirPedidoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com/", name = "recibirPedidoResponse")
    public JAXBElement<RecibirPedidoResponse> createRecibirPedidoResponse(RecibirPedidoResponse value) {
        return new JAXBElement<RecibirPedidoResponse>(_RecibirPedidoResponse_QNAME, RecibirPedidoResponse.class, null, value);
    }

}

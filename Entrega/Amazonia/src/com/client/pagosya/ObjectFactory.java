
package com.client.pagosya;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.client.pagosya package. 
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

    private final static QName _RealizarPago_QNAME = new QName("http://com/", "realizarPago");
    private final static QName _RealizarPagoResponse_QNAME = new QName("http://com/", "realizarPagoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.client.pagosya
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RealizarPago }
     * 
     */
    public RealizarPago createRealizarPago() {
        return new RealizarPago();
    }

    /**
     * Create an instance of {@link RealizarPagoResponse }
     * 
     */
    public RealizarPagoResponse createRealizarPagoResponse() {
        return new RealizarPagoResponse();
    }

    /**
     * Create an instance of {@link PagosYaResponse }
     * 
     */
    public PagosYaResponse createPagosYaResponse() {
        return new PagosYaResponse();
    }

    /**
     * Create an instance of {@link PagosYaRequest }
     * 
     */
    public PagosYaRequest createPagosYaRequest() {
        return new PagosYaRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RealizarPago }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com/", name = "realizarPago")
    public JAXBElement<RealizarPago> createRealizarPago(RealizarPago value) {
        return new JAXBElement<RealizarPago>(_RealizarPago_QNAME, RealizarPago.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RealizarPagoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com/", name = "realizarPagoResponse")
    public JAXBElement<RealizarPagoResponse> createRealizarPagoResponse(RealizarPagoResponse value) {
        return new JAXBElement<RealizarPagoResponse>(_RealizarPagoResponse_QNAME, RealizarPagoResponse.class, null, value);
    }

}

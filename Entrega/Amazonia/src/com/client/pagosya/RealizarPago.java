
package com.client.pagosya;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para realizarPago complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="realizarPago">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PagosYaRequest" type="{http://com/}pagosYaRequest"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "realizarPago", propOrder = {
    "pagosYaRequest"
})
public class RealizarPago {

    @XmlElement(name = "PagosYaRequest", required = true)
    protected PagosYaRequest pagosYaRequest;

    /**
     * Obtiene el valor de la propiedad pagosYaRequest.
     * 
     * @return
     *     possible object is
     *     {@link PagosYaRequest }
     *     
     */
    public PagosYaRequest getPagosYaRequest() {
        return pagosYaRequest;
    }

    /**
     * Define el valor de la propiedad pagosYaRequest.
     * 
     * @param value
     *     allowed object is
     *     {@link PagosYaRequest }
     *     
     */
    public void setPagosYaRequest(PagosYaRequest value) {
        this.pagosYaRequest = value;
    }

}

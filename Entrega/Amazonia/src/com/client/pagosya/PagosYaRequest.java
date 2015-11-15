
package com.client.pagosya;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para pagosYaRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="pagosYaRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fechaHora" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idCompra" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="monto" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="nroTarjeta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pagosYaRequest", propOrder = {
    "fechaHora",
    "idCompra",
    "monto",
    "nroTarjeta"
})
public class PagosYaRequest {

    protected String fechaHora;
    protected long idCompra;
    protected double monto;
    protected String nroTarjeta;

    /**
     * Obtiene el valor de la propiedad fechaHora.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaHora() {
        return fechaHora;
    }

    /**
     * Define el valor de la propiedad fechaHora.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaHora(String value) {
        this.fechaHora = value;
    }

    /**
     * Obtiene el valor de la propiedad idCompra.
     * 
     */
    public long getIdCompra() {
        return idCompra;
    }

    /**
     * Define el valor de la propiedad idCompra.
     * 
     */
    public void setIdCompra(long value) {
        this.idCompra = value;
    }

    /**
     * Obtiene el valor de la propiedad monto.
     * 
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Define el valor de la propiedad monto.
     * 
     */
    public void setMonto(double value) {
        this.monto = value;
    }

    /**
     * Obtiene el valor de la propiedad nroTarjeta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroTarjeta() {
        return nroTarjeta;
    }

    /**
     * Define el valor de la propiedad nroTarjeta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroTarjeta(String value) {
        this.nroTarjeta = value;
    }

}

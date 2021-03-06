
package com.client.epuerto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ePuertoPedidoRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ePuertoPedidoRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idCompra" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idProducto" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ePuertoPedidoRequest", propOrder = {
    "cantidad",
    "idCompra",
    "idProducto"
})
public class EPuertoPedidoRequest {

    protected int cantidad;
    protected String idCompra;
    protected long idProducto;

    /**
     * Obtiene el valor de la propiedad cantidad.
     * 
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     */
    public void setCantidad(int value) {
        this.cantidad = value;
    }

    /**
     * Obtiene el valor de la propiedad idCompra.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCompra() {
        return idCompra;
    }

    /**
     * Define el valor de la propiedad idCompra.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCompra(String value) {
        this.idCompra = value;
    }

    /**
     * Obtiene el valor de la propiedad idProducto.
     * 
     */
    public long getIdProducto() {
        return idProducto;
    }

    /**
     * Define el valor de la propiedad idProducto.
     * 
     */
    public void setIdProducto(long value) {
        this.idProducto = value;
    }

}

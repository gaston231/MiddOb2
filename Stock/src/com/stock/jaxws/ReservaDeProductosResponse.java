
package com.stock.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.7.17
 * Sun Nov 01 19:48:39 UYST 2015
 * Generated source version: 2.7.17
 */

@XmlRootElement(name = "ReservaDeProductosResponse", namespace = "http://stock.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReservaDeProductosResponse", namespace = "http://stock.com/")

public class ReservaDeProductosResponse {

    @XmlElement(name = "return")
    private com.stock.ResultadoPedido _return;

    public com.stock.ResultadoPedido getReturn() {
        return this._return;
    }

    public void setReturn(com.stock.ResultadoPedido new_return)  {
        this._return = new_return;
    }

}


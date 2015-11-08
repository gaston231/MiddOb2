package com;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService
public interface IAmazoniaPagosYa {
	PagosYaResponse realizarPago(@XmlElement(name = "PagosYaRequest", required = true)PagosYaRequest request);
}

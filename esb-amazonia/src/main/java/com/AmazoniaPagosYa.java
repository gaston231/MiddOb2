package com;

import javax.jws.WebService;

@WebService(endpointInterface = "com.AmazoniaPagosYa",serviceName = "AmazoniaPagosYa")
public class AmazoniaPagosYa implements IAmazoniaPagosYa{

	public String hacerAlgo(String texto){
		return "hola " + texto;
	}
}

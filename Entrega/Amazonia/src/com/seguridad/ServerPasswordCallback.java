package com.seguridad;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class ServerPasswordCallback implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException,
	 UnsupportedCallbackException {

	 

	 WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];

	 if (pc.getUsage() == WSPasswordCallback.SIGNATURE)

	 if (pc.getIdentifier().equals("middleware"))
	 pc.setPassword("middleware");
	 }

	 
}



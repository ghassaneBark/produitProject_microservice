package com.clientui.clientui.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder{

	
	  private final ErrorDecoder defaultErrorDecoder = new Default();

	@Override
	public Exception decode(String methodKey, Response response) {
		 if(response.status() == 400 ) {
		        return new ProductBadRequestException(
		              "Requête incorrecte "
		        );
		      }
		      return defaultErrorDecoder.decode(methodKey, response);
	}

}

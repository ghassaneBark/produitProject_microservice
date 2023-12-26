package com.mexpedition.microserviceexpedition.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExpeditionExceptionIntrouvable  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExpeditionExceptionIntrouvable(String s) {
		super(s);
	}

	
}

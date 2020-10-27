package com.br.projeto.exceptions.business;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AccountCreateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4613517064947702286L;
	
	public AccountCreateException(String message) {
		super(message);
	}
	
}

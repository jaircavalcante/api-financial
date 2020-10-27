package com.br.projeto.exceptions.business;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TransactionAmountInvalidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4613517064947702286L;
	
	public TransactionAmountInvalidException(String message) {
		super(message);
	}
	
}

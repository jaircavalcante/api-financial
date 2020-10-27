package com.br.projeto.exceptions.business;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class TransactionOperationTypeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6854016372384601943L;

	public TransactionOperationTypeException(String message) {
		super(message);
	}
	
}


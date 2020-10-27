package com.br.projeto.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.br.projeto.exceptions.business.AccountCreateException;
import com.br.projeto.exceptions.business.AccountNotFoundException;
import com.br.projeto.exceptions.business.TransactionAmountInvalidException;
import com.br.projeto.exceptions.business.TransactionCreateException;

@ControllerAdvice
public class ExceptionHandlerRest extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AccountCreateException.class)
	public final ResponseEntity<?> handleExceptionCreateAccount(AccountCreateException ex, WebRequest request) {
		ErrorResponse errorDetails = new ErrorResponse(ex.getLocalizedMessage(), LocalDateTime.now() , ex.getCause());
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(AccountNotFoundException.class)
	public final ResponseEntity<?> handleExceptionNotFoundAccount(AccountCreateException ex, WebRequest request) {
		ErrorResponse errorDetails = new ErrorResponse(ex.getLocalizedMessage(), LocalDateTime.now() , ex.getCause());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TransactionCreateException.class)
	public final ResponseEntity<?> handleExceptionCreateTransaction(TransactionCreateException ex, WebRequest request) {
		ErrorResponse errorDetails = new ErrorResponse(ex.getLocalizedMessage(), LocalDateTime.now() , ex.getCause());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TransactionAmountInvalidException.class)
	public final ResponseEntity<?> handleExceptionAmountInvalid(TransactionAmountInvalidException ex, WebRequest request) {
		ErrorResponse errorDetails = new ErrorResponse(ex.getLocalizedMessage(), LocalDateTime.now() , ex.getCause());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
}

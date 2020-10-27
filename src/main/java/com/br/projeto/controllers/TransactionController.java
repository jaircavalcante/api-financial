package com.br.projeto.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.projeto.entity.Transaction;
import com.br.projeto.entity.bean.TransactionBean;
import com.br.projeto.exceptions.business.TransactionCreateException;
import com.br.projeto.services.ITransactionService;
import com.br.projeto.util.MessageProperties;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Transaction", tags = {"Transaction"})
public class TransactionController {

	@Autowired
	private ITransactionService transactionService;

	@PostMapping
	@ApiOperation(value = "Create New Transaction")
	public ResponseEntity<Transaction> createNewAccount(@RequestBody @Valid TransactionBean transactionBean) throws Exception {
		Transaction transaction = transactionService.create(transactionBean);

		if(transaction == null) {
			throw new TransactionCreateException(MessageProperties.getKey("transaction.not.created"));
		}
		
		return new ResponseEntity<>(transaction, HttpStatus.CREATED);
	}
}
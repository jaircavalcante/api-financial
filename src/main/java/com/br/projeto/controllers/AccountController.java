package com.br.projeto.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.projeto.entity.dto.AccountDTO;
import com.br.projeto.exceptions.business.AccountCreateException;
import com.br.projeto.exceptions.business.AccountNotFoundException;
import com.br.projeto.services.IAccountService;
import com.br.projeto.util.MessageProperties;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Account", tags = {"Account"})
public class AccountController {

	@Autowired
	private IAccountService accountService;

	@PostMapping
	@ApiOperation(value = "Create New Account")
	public ResponseEntity<AccountDTO> createNewAccount() throws AccountCreateException, IOException {
		AccountDTO accountNumber = accountService.createNewAccount();
		
		if(accountNumber == null) {
			throw new AccountCreateException(MessageProperties.getKey("account.not.created"));
		}
		
		return new ResponseEntity<AccountDTO>(accountNumber, HttpStatus.CREATED);
	}

	@GetMapping("/{accountId}")
	@ApiOperation(value = "Get Account Details")
	public ResponseEntity<AccountDTO> informationAccount(@PathVariable Long accountId) throws IOException {
		AccountDTO account = accountService.informationAccount(accountId);
		
		if(account == null) {
			throw new AccountNotFoundException(MessageProperties.getKey("account.not.find"));
		}

		return new ResponseEntity<>(account, HttpStatus.OK);
	}
}
package com.br.projeto.services;

import java.io.IOException;

import javax.validation.Valid;

import com.br.projeto.entity.dto.AccountDTO;

public interface IAccountService {
	
	/**
	 * Create new account
	 * @return accountDTO
	 * @throws IOException 
	 */
	AccountDTO createNewAccount() throws IOException;

	/**
	 * Get Information about account
	 * @param id
	 * @return account
	 * @throws Exception 
	 */
	AccountDTO informationAccount(@Valid Long id) throws Exception;
	
}

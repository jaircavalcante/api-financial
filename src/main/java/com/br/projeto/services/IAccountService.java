package com.br.projeto.services;

import javax.validation.Valid;

import com.br.projeto.entity.dto.AccountDTO;

public interface IAccountService {
	
	/**
	 * Create new account
	 * @return accountDTO
	 */
	AccountDTO createNewAccount();

	/**
	 * Get Information about account
	 * @param id
	 * @return account
	 */
	AccountDTO informationAccount(@Valid Long id);
	
}

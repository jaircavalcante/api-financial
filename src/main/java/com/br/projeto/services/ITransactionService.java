package com.br.projeto.services;

import javax.validation.Valid;

import com.br.projeto.entity.Transaction;
import com.br.projeto.entity.bean.TransactionBean;

public interface ITransactionService {
	
	/**
	 * Create new transaction
	 * @param transactionBean 
	 * @return transactionDTO
	 * @throws Exception 
	 */
	Transaction create(@Valid TransactionBean transactionBean) throws Exception;

}

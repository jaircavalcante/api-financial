package com.br.projeto.services.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.projeto.entity.Account;
import com.br.projeto.entity.Transaction;
import com.br.projeto.entity.bean.TransactionBean;
import com.br.projeto.enums.OperationsTypes;
import com.br.projeto.exceptions.business.AccountNotFoundException;
import com.br.projeto.exceptions.business.TransactionAmountInvalidException;
import com.br.projeto.exceptions.business.TransactionOperationTypeException;
import com.br.projeto.repository.AccountRepository;
import com.br.projeto.repository.TransactionRepository;
import com.br.projeto.services.ITransactionService;
import com.br.projeto.util.MessageProperties;
import com.br.projeto.util.Utility;


@Service
public class TransactionServiceImpl implements ITransactionService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	
	@Autowired
	private TransactionRepository repository;
	
	
	
	@Override
	public Transaction create(TransactionBean transactionBean) throws Exception {
		Account account = new Account();
		
		/**
		 * Validating account
		 */
		if(transactionBean.getAccountId() != null) {
			Optional<Account> accountFind = accountRepository.findById(transactionBean.getAccountId());
			if(!accountFind.isPresent()) {
				throw new AccountNotFoundException(MessageProperties.getKey("account.not.find"));
			}
		}
		
		/**
		 * Validating value amount
		 */
		if(transactionBean.getAmount() <= 0) {
			throw new TransactionAmountInvalidException(MessageProperties.getKey("amount.invalid"));
		}
		
		/**
		 * Validating operation type
		 */
		if(OperationsTypes.getValue(transactionBean.getOperationTypeId())) {
			throw new TransactionOperationTypeException(MessageProperties.getKey("operation.type.invalid"));
		}
		
		Transaction transaction = new Transaction();
		account.setId(transactionBean.getAccountId());
		transaction.setAccount(account);
		transaction.setAmount(Utility.validateTypeTransaction(transactionBean.getOperationTypeId(),transactionBean.getAmount()));
		transaction.setEventDate(new Date());
		transaction.setOperationType(transactionBean.getOperationTypeId());
		
		return repository.save(transaction);
	}
}

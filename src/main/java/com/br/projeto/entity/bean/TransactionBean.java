package com.br.projeto.entity.bean;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class TransactionBean {

    @NotNull(message = "Account Id is not null")
	private Long accountId;

	@NotNull(message = "Operation Type Id is not null")
	private Long operationTypeId;
	
	@NotNull(message = "Amount is not null")
	private Long amount;
	
}

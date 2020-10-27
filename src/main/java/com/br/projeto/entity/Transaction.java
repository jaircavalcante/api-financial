package com.br.projeto.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "TB_TRANSACTION")
public class Transaction implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5768629755286556840L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "TRANSACTION_ID")
	private Long id;
	
	@NotNull
	@ManyToOne
    @JoinColumn(name="account_id")
    private Account account;
	
	@Column(name = "OPERATIONTYPE_ID")
	private Long operationType;
	
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EVENT_DATE")
	private Date eventDate;
	
}
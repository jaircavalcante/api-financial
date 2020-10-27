package com.br.projeto.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.br.projeto.enums.OperationsTypes;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "TB_OPERATION_TYPES")
public class OperationType implements Serializable {
	 
	private static final long serialVersionUID = 8884724090010544495L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "OPERATIONTYPE_ID")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "DESCRIPTION")
	private OperationsTypes description;
	
}

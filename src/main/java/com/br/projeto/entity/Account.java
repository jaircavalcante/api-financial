package com.br.projeto.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_ACCOUNTS")
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7244753479971092898L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ACCOUNT_ID")
	private Long id;

	@NotNull
	@Column(name = "DOCUMENT_NUMBER")
	private Long documentNumber;

	@Transient
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private List<Transaction> transactions;
	
}

package com.br.projeto.entity.dto;

import lombok.Data;

/**
 * 
 * @author jaircavalcante
 *
 */

@Data
public class AccountDTO {
	
	private Long id;

	private Long document_number;
	
	public AccountDTO(Long documentNumber){
		this.document_number = documentNumber;
	}
	
	public AccountDTO(Long id, Long documentNumber) {
		this.id = id;
		this.document_number = documentNumber;
	}

	public AccountDTO() {}
}
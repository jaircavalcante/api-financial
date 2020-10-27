package com.br.projeto.enums;

import java.util.Arrays;

import lombok.Getter;

/**
 * 
 * @author jaircavalcante
 *
 */
public enum OperationsTypes {
	
	COMPRA_A_VISTA(1),
	
	COMPRA_PARCELADA(2),
	
	SAQUE(3),
	
	PAGAMENTO(4);
	
	@Getter
	private Integer value;
	
	private OperationsTypes(Integer value) {
		this.value = value;
	}
	
	public static boolean getValue(Long operationTypeId) {
		return Arrays.stream(OperationsTypes.values()).filter(type -> type.value.equals(operationTypeId)).findFirst().isPresent();
	}
}

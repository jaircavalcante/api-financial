package com.br.projeto.util;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

import com.br.projeto.enums.OperationsTypes;

public final class Utility {
	
	private Utility() {}
	
	public static Long generateNumberDocument() {
		return ThreadLocalRandom.current().nextLong();
	}

	public static BigDecimal validateTypeTransaction(Long operationTypeId, Long amount) {
		if(OperationsTypes.PAGAMENTO.getValue().longValue() == operationTypeId) {
			return new BigDecimal(amount);
		}
	
		return new BigDecimal(amount).negate();
	}
}

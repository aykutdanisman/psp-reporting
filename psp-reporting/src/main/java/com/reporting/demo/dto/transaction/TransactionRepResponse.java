package com.reporting.demo.dto.transaction;

import com.reporting.demo.dto.common.Dto;
import com.reporting.demo.entity.enumr.Currency;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransactionRepResponse implements Dto{

	private Long count;
	private Double total;
	private Currency currency;
	
	public TransactionRepResponse(Long count, Double total, Currency currency) {
		this.count = count;
		this.total = total;
		this.currency = currency;
	}

}

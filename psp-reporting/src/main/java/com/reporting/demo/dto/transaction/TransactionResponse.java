package com.reporting.demo.dto.transaction;

import com.reporting.demo.dto.acquirer.AcquirerResponse;
import com.reporting.demo.dto.common.Dto;
import com.reporting.demo.dto.customer.CustomerResponse;
import com.reporting.demo.dto.merchant.MerchantResponse;
import com.reporting.demo.entity.enumr.Currency;
import com.reporting.demo.entity.enumr.TransactionStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse implements Dto{

	private Long id;
	private MerchantResponse merchant;
	private AcquirerResponse acquirer;
	private Double amount;
	private Currency currency;
	private TransactionStatus status;
	private CustomerResponse customer;
	private String refNo;

}

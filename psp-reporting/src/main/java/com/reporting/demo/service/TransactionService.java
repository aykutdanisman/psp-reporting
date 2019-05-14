package com.reporting.demo.service;

import java.util.List;

import com.reporting.demo.dto.customer.CustomerResponse;
import com.reporting.demo.dto.transaction.TransactionRepRequest;
import com.reporting.demo.dto.transaction.TransactionRepResponse;

public interface TransactionService {
	

	List<TransactionRepResponse> getTransactionReport(TransactionRepRequest req);
	List<CustomerResponse> getCustomerInfo4Transaction(TransactionRepRequest req);

}

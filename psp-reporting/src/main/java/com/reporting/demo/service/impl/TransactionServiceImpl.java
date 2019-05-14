package com.reporting.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.reporting.demo.dto.customer.CustomerResponse;
import com.reporting.demo.dto.transaction.TransactionRepRequest;
import com.reporting.demo.dto.transaction.TransactionRepResponse;
import com.reporting.demo.entity.Customer;
import com.reporting.demo.repo.TransactionRepository;
import com.reporting.demo.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	private final TransactionRepository transactionRepo;
	private final ModelMapper modelMapper;
	
	public TransactionServiceImpl(TransactionRepository transactionRepo, ModelMapper modelMapper) {
		this.transactionRepo = transactionRepo;
		this.modelMapper = modelMapper;
	}
	
	
	@Override
	public List<TransactionRepResponse> getTransactionReport(TransactionRepRequest req) {
		 return transactionRepo.getTransactionRepot(req.getFromDate(),req.getToDate());
	}


	@Override
	public List<CustomerResponse> getCustomerInfo4Transaction(TransactionRepRequest req) {
		List<Customer> list =  transactionRepo.getCustomerInfo4Transaction(req.getTransactionId());
		return list.stream().map(entity -> modelMapper.map(entity ,CustomerResponse.class)).collect(Collectors.toList());
	}
	

}

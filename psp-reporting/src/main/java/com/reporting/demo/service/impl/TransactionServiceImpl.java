package com.reporting.demo.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.reporting.demo.dto.transaction.TransactionRepRequest;
import com.reporting.demo.dto.transaction.TransactionRepResponse;
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
		
//		List<Transactions> list =  transactionRepo.getTransactionRepot(req);
//		return list.stream().map(entity -> modelMapper.map(entity ,TransactionRepResponse.class)).collect(Collectors.toList());
		 return transactionRepo.getTransactionRepot(req.getFromDate(),req.getToDate());
		
	}
	

}

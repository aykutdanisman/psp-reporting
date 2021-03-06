package com.reporting.demo.api;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reporting.demo.dto.common.ResultDTO;
import com.reporting.demo.dto.transaction.TransactionRepRequest;
import com.reporting.demo.service.impl.TransactionServiceImpl;

@RestController
@RequestMapping("/api/v3/transactions")
public class TransactionController {
	
	@Autowired
    private TransactionServiceImpl transactionService;
	
	
	@GetMapping("/report")
    public ResponseEntity<ResultDTO> getTransactionReport(@RequestBody @Valid TransactionRepRequest req)
	{
		try {
			ResultDTO result = new ResultDTO();
			result.setResponse(transactionService.getTransactionReport(req));
			result.setStatus("APPROVED");
			return ResponseEntity.ok(result);
		} catch (NoSuchElementException e) {//if no record found
			return ResponseEntity.noContent().build();//return 204
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();////return 500
		}
		
    }
	
	
	
	

 

}

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
@RequestMapping("/api/v3")
public class ClientController {
	
	@Autowired
    private TransactionServiceImpl transactionService;
	
	
	@GetMapping("/client")
    public ResponseEntity<ResultDTO> getClientByTID(@RequestBody @Valid TransactionRepRequest req)
	{
		ResultDTO result = new ResultDTO();
		try {
			result.setResponse(transactionService.getCustomerInfo4Transaction(req));
			result.setStatus("APPROVED");
			return ResponseEntity.ok(result);
		} catch (NoSuchElementException e) {//if no record found
			result.setResponse(null);
			result.setStatus("EMPTY");
			return ResponseEntity.ok(result);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();////return 500
		}
		
    }
	
	
	
	

 

}

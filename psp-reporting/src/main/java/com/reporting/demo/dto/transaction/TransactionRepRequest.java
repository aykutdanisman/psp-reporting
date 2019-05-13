package com.reporting.demo.dto.transaction;

import java.util.Date;

import com.reporting.demo.dto.common.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRepRequest implements Dto {

	private Date fromDate; 
	private Date toDate;
	private Long merchant;
	private Long acquirer;
	
}

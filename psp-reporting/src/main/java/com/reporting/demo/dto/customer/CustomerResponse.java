package com.reporting.demo.dto.customer;

import com.reporting.demo.dto.common.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse implements Dto{

	private Long id;
	private String email;
	private String billingFirstName;

}

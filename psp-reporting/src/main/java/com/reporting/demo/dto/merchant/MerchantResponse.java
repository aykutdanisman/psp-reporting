package com.reporting.demo.dto.merchant;

import com.reporting.demo.dto.common.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchantResponse implements Dto{

	private Long id;
	private String name;

}

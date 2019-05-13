package com.reporting.demo.dto.acquirer;

import com.reporting.demo.dto.common.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcquirerResponse implements Dto{

	private Long id;
	private String name;

}

package com.reporting.demo.dto.common;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {
	
	private String status;
	private List<?> response;
	private ErrorDTO errorDetail;

}

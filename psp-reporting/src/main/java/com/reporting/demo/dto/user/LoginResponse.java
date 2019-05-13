package com.reporting.demo.dto.user;

import org.springframework.http.HttpStatus;

import com.reporting.demo.dto.common.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse implements Dto{

	private HttpStatus status;
	private String token;

}

package com.reporting.demo.dto.user;

import javax.validation.constraints.NotBlank;

import com.reporting.demo.dto.common.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest implements Dto{

	@NotBlank
	private String password;
	@NotBlank
	private String email;

}

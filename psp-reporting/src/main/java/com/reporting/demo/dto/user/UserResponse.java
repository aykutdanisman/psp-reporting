package com.reporting.demo.dto.user;

import com.reporting.demo.dto.common.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Is used to return the user data to the clients
 * @author aykut
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse implements Dto{

	private Long id;
	private String name;
	private String surname;
	private String password;
	private String roleName;
	private String email;

}

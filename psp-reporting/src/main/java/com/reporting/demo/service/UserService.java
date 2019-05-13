package com.reporting.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.reporting.demo.dto.user.LoginResponse;
import com.reporting.demo.dto.user.UserResponse;
import com.reporting.demo.entity.User;

public interface UserService {
	
	UserResponse getByEmail(String email);

	Page<UserResponse> getAllPageable(Pageable pageable);

	User getUser4Login(String email);
	


}

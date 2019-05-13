package com.reporting.demo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.reporting.demo.dto.user.UserResponse;
import com.reporting.demo.entity.User;
import com.reporting.demo.repo.UserRepository;
import com.reporting.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepo;
	private final ModelMapper modelMapper;
	
	public UserServiceImpl(UserRepository userRepo, ModelMapper modelMapper) {
		this.userRepo = userRepo;
		this.modelMapper = modelMapper;
	}



	/**
	 * fetches the user entity with spring Pageble
	 */
	@Override
	public Page<UserResponse> getAllPageable(Pageable pageable) {
		Page<User> page =  userRepo.findAll(pageable);
		return page.map( e-> modelMapper.map(e ,UserResponse.class));
	}


	@Override
	public UserResponse getByEmail(String email) {
		return modelMapper.map(userRepo.findByEmail(email).get(), UserResponse.class);
	}
	
	@Override
	public User getUser4Login(String email) {
		return userRepo.findByEmail(email).get();
	}

}

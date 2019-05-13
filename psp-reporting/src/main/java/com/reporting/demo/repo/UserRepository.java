package com.reporting.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reporting.demo.dto.user.LoginResponse;
import com.reporting.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Page<User> findAll(Pageable pageable);
	List<User> findAll(Sort sort);
	Optional<User> findByEmail(String email);
	
}

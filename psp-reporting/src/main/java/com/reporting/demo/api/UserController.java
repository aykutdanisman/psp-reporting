package com.reporting.demo.api;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reporting.demo.dto.user.LoginRequest;
import com.reporting.demo.dto.user.LoginResponse;
import com.reporting.demo.dto.user.UserResponse;
import com.reporting.demo.security.JwtTokenFactory;
import com.reporting.demo.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/v3/merchant/user")
public class UserController {
	
	@Autowired
    private UserServiceImpl userService;
	
	@Autowired
    AuthenticationManager authenticationManager;
	
	@Autowired
    JwtTokenFactory tokenFactory;
	
	
	@GetMapping("/getByEmail")
    public ResponseEntity<UserResponse> getByEmail(@RequestParam(value = "email") String email) {
        
		try {
			return ResponseEntity.ok(userService.getByEmail(email));
		} catch (NoSuchElementException e) {//if no record found
			return ResponseEntity.noContent().build();//return 204
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();////return 500
		}
		
    }
	
	
	
	@PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest req) {
		
		Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		req.getEmail(),
                		req.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenFactory.generateToken(authentication);
        return new ResponseEntity<>(new LoginResponse(HttpStatus.OK, jwt), HttpStatus.CREATED);
		
    }

 

}

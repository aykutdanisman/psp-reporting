package com.reporting.demo.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.reporting.demo.entity.User;
import com.reporting.demo.security.UserPrincipal;
import com.reporting.demo.service.UserService;

import lombok.NonNull;

@Component
public class CustomAuthenticationManager implements AuthenticationManager {

    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(@NonNull final Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        try {
        	User user = userService.getUser4Login(username);
            if (user == null) {
                throw new BadCredentialsException("1000");
            }

            if (!passwordEncoder.matches(password, user.getPassword())) {
                throw new BadCredentialsException("1000");
            }
            List<GrantedAuthority> authorities = Arrays.asList(new String[] {user.getRoleName()}).stream().map(role ->
            new SimpleGrantedAuthority(role)).collect(Collectors.toList());

            return new UsernamePasswordAuthenticationToken(UserPrincipal.create(user), password, authorities);

        } catch (Exception e) {
        	throw new BadCredentialsException("1000");
        }

    }

}
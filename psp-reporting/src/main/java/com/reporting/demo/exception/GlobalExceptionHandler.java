package com.reporting.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.reporting.demo.dto.common.ErrorDTO;
import com.reporting.demo.dto.common.ResultDTO;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(UserNotFoundException ex, WebRequest request) {
		ErrorDTO errorDetails = new ErrorDTO(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(new ResultDTO("ERROR",null,errorDetails), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDTO errorDetails = new ErrorDTO(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(new ResultDTO("ERROR",null,errorDetails), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
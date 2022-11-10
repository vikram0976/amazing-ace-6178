package com.food.exception;

import java.net.http.HttpRequest;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails> myExceptionHandler(Exception ie, WebRequest wr){
		
		
	ErrorDetails err = new ErrorDetails();
	err.setTimestamp(LocalDateTime.now());
	err.getMessage();
	err.setDescription(wr.getDescription(false));
	
	return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	 
		
		
	}

}

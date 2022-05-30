package com.capg.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralExceptionHandler {
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> customerExceptionHandler(CustomerNotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){
		return new ResponseEntity<List<String>>(ex.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()),HttpStatus.BAD_REQUEST);
	}

}

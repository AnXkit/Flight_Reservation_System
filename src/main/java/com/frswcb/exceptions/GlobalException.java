package com.frswcb.exceptions;

import java.util.Date;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;




@ControllerAdvice
 
public class GlobalException {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundHandling(ResourceNotFoundException ex , 
			WebRequest request)
	{
		ErrorDetails errors = new ErrorDetails(new Date(),
				ex.getMessage() , request.getDescription(false));
		return new ResponseEntity<>(errors , HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> handleDataIntegrityViolation(DataIntegrityViolationException ex ,
			WebRequest request)
	{
		ErrorDetails errors = new ErrorDetails(new Date(),
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
}

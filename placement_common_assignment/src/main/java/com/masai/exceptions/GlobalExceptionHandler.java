package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(CourseException.class)
	public ResponseEntity<MyErrorDetails> myExpHandle(CourseException le,WebRequest wr) {
		
		MyErrorDetails err=new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(le.getMessage());
		err.setDetails(wr.getDescription(false));
		
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
		
	}
	
	
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<MyErrorDetails> myExpHandle(StudentException le,WebRequest wr) {
		
		MyErrorDetails err=new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(le.getMessage());
		err.setDetails(wr.getDescription(false));
		
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
		
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExpHandle(Exception e,WebRequest wr) {
		
		MyErrorDetails err=new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(wr.getDescription(false));
		
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
		
	}	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> methodArgNotValidExp(MethodArgumentNotValidException me,WebRequest wr) {
		
		MyErrorDetails err=new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage("Validation error");
		err.setDetails(wr.getDescription(false));
		
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
			
	}

}

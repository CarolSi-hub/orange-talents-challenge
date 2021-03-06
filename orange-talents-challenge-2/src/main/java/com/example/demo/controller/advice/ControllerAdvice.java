package com.example.demo.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

public class ControllerAdvice {
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ResponseBody
	    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

	        return ex.getBindingResult().getFieldError().getField() + " - " + ex.getBindingResult().getFieldError().getDefaultMessage();
	    }

	    @ExceptionHandler(Exception.class)
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    @ResponseBody
	    public String handleException(Exception ex) {
	        return "Internal Server Error: " + ex.getMessage();
	    }

	    @ExceptionHandler(ResourceNotFoundException.class)
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    @ResponseBody
	    public String handleResourceNotFoundException(ResourceNotFoundException ex) {
	        return ex.getMessage();
	    }
	    
	    @ExceptionHandler(SQLException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public String handleSQLException(ResourceNotFoundException ex) {
	        return ex.getMessage();
	    }
	   

}

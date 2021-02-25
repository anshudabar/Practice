package com.demo.bookapp.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bookapp.dao.ErrorMessage;
import com.demo.bookapp.exceptions.BookNotFoundException;

@ControllerAdvice
@RestController
public class ExceptionHandlerController {
	
	
	//responseEntity = response + httpStatuscode
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorMessage> getMessage(BookNotFoundException ex){
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorMessage(ex.getMessage());
		errorMessage.setContactMail("meghna@yamaha-motor-india.com");
		errorMessage.setTimeStamp(new Date());
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.NOT_FOUND);
	}
	
	
}

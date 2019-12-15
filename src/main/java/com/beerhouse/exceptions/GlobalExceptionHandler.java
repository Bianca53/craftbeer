package com.beerhouse.exceptions;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.beerhouse.responses.CustomErrorMessage;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<CustomErrorMessage> handleNotFoundException(NotFoundException ex, WebRequest request)
			throws IOException {
		CustomErrorMessage errorMessage = new CustomErrorMessage();
		errorMessage.setMessage(ex.getMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
}

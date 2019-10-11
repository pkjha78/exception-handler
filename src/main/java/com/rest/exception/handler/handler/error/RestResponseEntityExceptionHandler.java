package com.rest.exception.handler.handler.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler {

	@ExceptionHandler(CreditApplicationNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleCreditApplicationAlreadyExistsException(CreditApplicationNotFoundException ex,
			WebRequest request) {
		ErrorDetails exceptionResponse = new ErrorDetails("404", HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CreditApplicationAlreadyExistsException.class)
	public final ResponseEntity<ErrorDetails> handleCreditApplicationAlreadyExistsException(CreditApplicationAlreadyExistsException ex,
			WebRequest request) {
		ErrorDetails exceptionResponse = new ErrorDetails("409", HttpStatus.CONFLICT.getReasonPhrase(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
	}
}

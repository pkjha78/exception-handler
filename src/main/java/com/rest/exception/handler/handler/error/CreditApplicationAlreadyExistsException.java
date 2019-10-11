package com.rest.exception.handler.handler.error;

public class CreditApplicationAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public CreditApplicationAlreadyExistsException(Long id){
		super("Credit application already exists for customer ID: '" + id + "'");
	}
}

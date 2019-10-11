package com.rest.exception.handler.handler.error;

public class CreditApplicationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7628476543661892343L;
	
	public CreditApplicationNotFoundException(Long id) {
		super("could not find credit application with ID: '" + id + "'");
	}
}

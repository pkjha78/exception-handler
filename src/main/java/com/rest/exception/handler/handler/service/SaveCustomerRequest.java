package com.rest.exception.handler.handler.service;

import com.rest.exception.handler.handler.domain.Customer;

import lombok.Data;

@Data
public class SaveCustomerRequest {
	protected Customer customer;	
}

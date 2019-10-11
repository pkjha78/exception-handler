package com.rest.exception.handler.handler.controller.rest.v1;

import com.rest.exception.handler.handler.domain.Customer;
import com.rest.exception.handler.handler.entity.CreditApplication;

import lombok.Data;

@Data
public class ProcessContainer {
	private Customer customer;
    private CreditApplication creditApplication;
}

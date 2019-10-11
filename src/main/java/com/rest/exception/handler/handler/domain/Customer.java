package com.rest.exception.handler.handler.domain;

import lombok.Data;

@Data
public class Customer {
	private Long id;
    private String firstName;
    private String lastName;
    private String street;
    private String postCode;
    private String city;
}

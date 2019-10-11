package com.rest.exception.handler.handler.domain;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import lombok.Data;

@Embeddable
@Data
public class SelfDisclosure {
	@Embedded
	private Earnings earnings;

	@Embedded
	private Outgoings outgoings;
}

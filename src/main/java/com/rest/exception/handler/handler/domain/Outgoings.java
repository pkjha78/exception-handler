package com.rest.exception.handler.handler.domain;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Outgoings {
	private long rent;
    private long loanRepayments;
    private long costOfLiving;
    
    public long sum() {
        return rent + loanRepayments + costOfLiving;
    }
}

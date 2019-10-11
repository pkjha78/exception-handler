package com.rest.exception.handler.handler.domain;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Earnings {
	long income;
    long childBenefit;
    long rentalIncome;
    
    public long sum() {
        return income + childBenefit + rentalIncome;
    }
}

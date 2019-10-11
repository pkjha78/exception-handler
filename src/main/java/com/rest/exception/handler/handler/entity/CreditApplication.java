package com.rest.exception.handler.handler.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.rest.exception.handler.handler.domain.SelfDisclosure;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Data
@ApiModel(description = "All details about the Credit Applicatiion. ")
public class CreditApplication {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	@ApiModelProperty(notes = "The database generated credit application ID")
    private Long id;

	@ApiModelProperty(notes = "The credit term ID")
    private int term;

    private BigDecimal amount;

    private String purpose;

    private BigDecimal percentage;

    @Transient
    private BigDecimal monthlyPayment;

    @Embedded
    private SelfDisclosure selfDisclosure;

    @ApiModelProperty(notes = "The customer ID")
    private Long customerId;
    
    public BigDecimal getMonthlyPayment() {
        return this.amount.divide(new BigDecimal(this.getTerm()), 2, RoundingMode.HALF_UP);
    }
}

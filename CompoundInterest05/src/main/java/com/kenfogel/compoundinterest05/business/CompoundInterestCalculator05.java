package com.kenfogel.compoundinterest05.business;

import com.kenfogel.compoundinterest05.data.CompoundInterestData05;

public class CompoundInterestCalculator05 {
    
    public void calculateCompoundInterest(CompoundInterestData05 value) {
        var result = value.getPrincipal() * Math.pow(1 + value.getAnnualInterestRate() / 
                value.getCompoundPerTimeUnit(), value.getTime() * value.getCompoundPerTimeUnit());
        value.setResult(result);

    }
}

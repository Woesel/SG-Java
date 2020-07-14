package com.tenzin.flooring.dto;

import java.math.BigDecimal;

/**
 *
 * @author Tenzin Woesel Jun 25, 2020
 */
public class FMTax {

    public String stateAbbreviation;
    public String stateName;
    public BigDecimal taxRate;

    public FMTax(String stateAbbreviation, String stateName, BigDecimal taxRate) {
        this.stateAbbreviation = stateAbbreviation;
        this.stateName = stateName;
        this.taxRate = taxRate;
    }

    public FMTax(String stateAbbreviation, BigDecimal taxRate) {
        this.stateAbbreviation = stateAbbreviation;
        this.taxRate = taxRate;
    }

    public FMTax(String state) {
        this.stateAbbreviation = state;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public String getStateName() {
        return stateName;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

}

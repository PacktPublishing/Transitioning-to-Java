package com.kenfogel.data;

import java.math.BigDecimal;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * This is a CDI bean that uses Bean Validation to determine if the entered
 * value is within the allowable range,
 *
 * @author Ken Fogel
 */
@Named("money")
@RequestScoped
public class FinanceBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(FinanceBean.class.getName());

    @DecimalMin(value = "1.00", message = "{com.kenfogel.minInput}")
    @DecimalMax(value = "100000.00", message = "{com.kenfogel.maxInput}")
    private BigDecimal inputValue;
    @DecimalMin(value = "0.00", message = "{com.kenfogel.minInput}")
    @DecimalMax(value = "1.00", message = "{com.kenfogel.maxInput}")
    private BigDecimal rate;
    @DecimalMin(value = "1.00", message = "{com.kenfogel.minInput}")
    @DecimalMax(value = "300.00", message = "{com.kenfogel.maxInput}")
    private BigDecimal term;
    private BigDecimal result;
    private String calculationType;
    private final ResourceBundle msgs;

    /**
     * Constructor that initializes all values and retrieves a reference to the
     * resource bundle
     */
    public FinanceBean() {
        result = BigDecimal.ZERO;
        inputValue = BigDecimal.ZERO;
        rate = BigDecimal.ZERO;
        term = BigDecimal.ZERO;
        calculationType = "loan";
        msgs = ResourceBundle.getBundle("com.kenfogel.bundles.MessagesBundle");
    }

    /**
     * Depending of the type of calculation, this returns the the text for the
     * inputValue label
     *
     * @return
     */
    public String getInputLabel() {
        return msgs.getString(calculationType);

    }

    public String getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(String calculationType) {
        this.calculationType = calculationType;
    }

    /*
     * The usual getters and setters follow
     */
    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public BigDecimal getInputValue() {
        return inputValue;
    }

    public void setInputValue(BigDecimal inputValue) {
        this.inputValue = inputValue;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getTerm() {
        return term;
    }

    public void setTerm(BigDecimal term) {
        this.term = term;
    }

}

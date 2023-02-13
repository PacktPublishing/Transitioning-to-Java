package com.kenfogel.bankfx.data;

import java.math.BigDecimal;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * This is our JavaFX bean where objects of type ObjectProperty are used in
 * place of primitives or other classes. The naming comvention for the setters
 * and getters makes this bean fully interchangable with a Java Bean.
 *
 * @author Ken Fogel
 */
public class FinanceFXBean {

    private ObjectProperty<BigDecimal> inputValue;
    private ObjectProperty<BigDecimal> rate;
    private ObjectProperty<BigDecimal> term;
    private ObjectProperty<BigDecimal> result;

    /**
     * Default constructor that does not take any parameters
     */
    public FinanceFXBean() {
        // Using the this reference one constructor can call another
        this(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
    }

    /**
     * Non-default constructor that expects three parameters. This instantiates
     * the four ObjectProperty objects.
     *
     * @param inputValue
     * @param rate
     * @param term
     */
    public FinanceFXBean(BigDecimal inputValue,
            BigDecimal rate, BigDecimal term) {
        this.inputValue
                = new SimpleObjectProperty<>(inputValue);
        this.rate
                = new SimpleObjectProperty<>(rate);
        this.term
                = new SimpleObjectProperty<>(term);
        this.result
                = new SimpleObjectProperty<>(BigDecimal.ZERO);
    }

    /**
     * Getter
     *
     * @return the actual value stored in the property
     */
    public BigDecimal getInputValue() {
        return inputValue.get();
    }

    /**
     * Setter
     *
     * @param inputValue the user entered value
     */
    public void setInputValue(BigDecimal inputValue) {
        this.inputValue.set(inputValue);
    }

    /**
     * Returns the property object for this value
     *
     * @return a reference to the property object for binding
     */
    public ObjectProperty<BigDecimal> inputValueProperty() {
        return inputValue;
    }

    public BigDecimal getRate() {
        return rate.get();
    }

    public void setRate(BigDecimal rate) {
        this.rate.set(rate);
    }

    public ObjectProperty<BigDecimal> rateProperty() {
        return rate;
    }

    public BigDecimal getTerm() {
        return term.get();
    }

    public void setTerm(BigDecimal term) {
        this.term.set(term);
    }

    public ObjectProperty<BigDecimal> termProperty() {
        return term;
    }

    public BigDecimal getResult() {
        return result.get();
    }

    public void setResult(BigDecimal result) {
        this.result.set(result);
    }

    public ObjectProperty<BigDecimal> resultProperty() {
        return result;
    }

    @Override
    public String toString() {
        return "FinanceBean{" + "inputValue=" + inputValue.get()
                + ", rate=" + rate.get() + ", term=" + term.get()
                + ", result=" + result.get() + '}';
    }

}

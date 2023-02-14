package com.kenfogel.bankfx.converter;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.util.converter.BigDecimalStringConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The supplied BigDecimalStringConverter has some issues such as throwing
 * exceptions that cannot be caught or throwing an exception if it tries to
 * convert a decimal point into a BigDecimal. This class will only convert a
 * text field into a BigDecimal if it passes the tests and pattern.
 *
 * @author Ken Fogel
 */
public class StringBigDecimalConverter extends BigDecimalStringConverter {

    private static final Logger LOG
            = LogManager.getLogger(StringBigDecimalConverter.class);

    private final Pattern numberPattern = Pattern.compile("^[\\d]*[\\.]?[\\d]*$");
    private final Matcher numberMatch = numberPattern.matcher("");

    @Override
    public BigDecimal fromString(String string) {
        if (!string.equals("") && !string.equals(".")
                && numberMatch.reset(string).matches()) {
            return new BigDecimal(string);
        }
        return BigDecimal.ZERO;
    }
}

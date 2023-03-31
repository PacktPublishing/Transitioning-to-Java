package com.kenfogel.bankfx.control;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This is our custom TextField. It only accepts numbers or a single period as
 * input thus ensuring it can be turned into a BigDecimal.
 *
 * @author Ken Fogel
 */
public class BigDecimalTextField extends TextField {

    private static final Logger LOG
            = LogManager.getLogger(BigDecimalTextField.class);

    /**
     * Here are two Regular Expression patterns pre-compiled and used to create
     * a Matcher object. While String objects have methods that can work with
     * Regular Expressions expressed as a string, they cannot use a pre-compiled
     * Pattern object and therefore are slower
     */
    private final Pattern numberPattern = Pattern.compile("^[\\d]*[\\.]?[\\d]*$");
    private final Matcher numberMatch = numberPattern.matcher("");
    private final Pattern zeroPattern = Pattern.compile("^0+(?!$)");
    private final Matcher zeroMatch = zeroPattern.matcher("");

    /**
     * This method is called for each character you enter. The whole string is
     * then checked with the Matcher.
     *
     * @param start The position of the first character that may be replaced
     * @param end The position of the last character to be replaced
     * @param text The new text
     */
    @Override
    public void replaceText(int start, int end, String text) {
        int caretPos = getCaretPosition();
        String oldValue = getText();
        if ((validate(text))) {
            super.replaceText(start, end, text);
            var newText = super.getText();
            /**
             * newText is the string that contains what you enterd and what may
             * already be in the text field. The validate method returns true if
             * newText is valid
             */
            if (!validate(newText)) {
                /**
                 * Failed test so restore the original string in the field
                 */
                super.setText(oldValue);
            } else {
                /**
                 * Passed test so the zeroPattern is used to replace any 
                 * leading zeros with an empty string.
                 */
                super.setText(zeroMatch.reset(newText).replaceAll(""));
            }
            // Position the cursor
            positionCaret(caretPos + 1);

        }
    }

    /**
     * Used when text is selected in the TextField and then replaced with new
     * text. Carries out the same operations as replaceText.
     *
     * @param text The new text
     */
    @Override
    public void replaceSelection(String text) {
        int caretPos = getCaretPosition();
        String oldValue = getText();
        if (validate(text)) {
            super.replaceSelection(text);
            var newText = super.getText();
            if (!validate(newText)) {
                super.setText(oldValue);
            } else {
                super.setText(zeroMatch.reset(newText).replaceAll(""));
            }
            positionCaret(caretPos);
        }

    }

    /**
     * Rather than repeat this code in each of the two places it is invoked, the
     * code is wrapped in a method.
     *
     * @param text
     * @return true if validated
     */
    private boolean validate(String text) {
        return ("".equals(text) || numberMatch.reset(text).matches());
    }
}

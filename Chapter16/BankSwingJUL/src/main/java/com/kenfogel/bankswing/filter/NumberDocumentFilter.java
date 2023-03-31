package com.kenfogel.bankswing.filter;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * Swing text controls have an object of type Document that holds the text
 * enetered into the control. To validate characters as they are added we need
 * to create a custom DocumentFilter. The replace method is called as you type
 * or if you cut or paste in the field.
 * 
 * Logging changed to JUL from log4j2 
 *
 * @author Ken Fogel
 */
public class NumberDocumentFilter extends DocumentFilter {

    private static final Logger LOG = Logger.getLogger(NumberDocumentFilter.class.getName());


    // The precompiled Pattern and the Matcher craeted from it.
    private final Pattern numberPattern
            = Pattern.compile("^[\\d]*[\\.]?[\\d]*$");
    private final Matcher numberMatch = numberPattern.matcher("");

    /**
     * This method constructs the complete text for a field and if it passes the
     * RegEx test then it is allowed otherwise the text does not change.
     *
     * @param fb provides access to the document
     * @param offset where the new text is goind
     * @param length the length of the new text
     * @param string the new text
     * @param attrs font, colour, and other visual elements
     * @throws BadLocationException
     */
    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length,
            String string, AttributeSet attrs) throws BadLocationException {
        var text = fb.getDocument().getText(0,
                fb.getDocument().getLength());
        var newText = text.substring(0, offset) + string
                + text.substring(offset + length);
        if (numberMatch.reset(newText).matches()) {
            super.replace(fb, offset, length, string, attrs);
        }
    }
}

package com.kenfogel.bankswing.presentation;

import com.kenfogel.bankswing.data.FinanceBean;
import com.kenfogel.bankswing.business.FinanceCalculations;
import com.kenfogel.bankswing.filter.NumberDocumentFilter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.AbstractDocument;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class builds the user interface and responds to events
 *
 * @author Ken Fogel
 */
public class FinanceCalculatorUI extends JPanel {

    private static final Logger LOG
            = LogManager.getLogger(FinanceCalculatorUI.class);

    private final FinanceBean financeData;
    private final FinanceCalculations calculator;

    private JTextField inputValue;
    private JTextField rateValue;
    private JTextField termValue;
    private JTextField resultValue;
    private JLabel inputLabel;
    private JLabel rateLabel;
    private JLabel termLabel;
    private JLabel titleLabel;
    private JPanel panelForm;

    private int calculationType;

    private final ResourceBundle form;

    private final Font labelFont;
    private final Font textFont;
    private final Font titleFont;

    private final NumberDocumentFilter filter;

    /**
     * Non-default constructor with three parameters
     *
     * @param calculator The business class
     * @param financeData The data class
     * @param form The ResourceBundle for i18n
     */
    public FinanceCalculatorUI(FinanceCalculations calculator,
            FinanceBean financeData, ResourceBundle form) {
        super(new BorderLayout());

        this.calculator = calculator;
        this.financeData = financeData;
        this.form = form;
        calculationType = 0; // Loan

        labelFont = new Font("Verdana", Font.BOLD, 18);
        textFont = new Font("Verdana", Font.PLAIN, 18);
        titleFont = new Font("Verdana", Font.BOLD, 24);

        configureJOptionPane();
        filter = new NumberDocumentFilter();
    }

    /**
     * This method constructs the user interface by adding elements to the Panel
     * that this class extends.
     *
     */
    public void buildFormPanel() {

        add(buildRadioButtonsPanel(), BorderLayout.NORTH);

        var innerForm = new JPanel(new BorderLayout());
        innerForm.add(buildTitleBox(), BorderLayout.NORTH);

        panelForm = new JPanel(new GridBagLayout());
        innerForm.add(panelForm, BorderLayout.CENTER);

        var format = NumberFormat.getNumberInstance();
        format.setGroupingUsed(false);

        inputLabel = new JLabel(form.getString("loan_amount"));
        inputLabel.setFont(labelFont);
        panelForm.add(inputLabel,
                getConstraints(0, 2, 1, 1, GridBagConstraints.WEST));

        inputValue = new JTextField("0");
        inputValue.setFont(textFont);
        inputValue.setHorizontalAlignment(SwingConstants.RIGHT);
        inputValue.setColumns(15);
        var inputDocument = (AbstractDocument) inputValue.getDocument();
        inputDocument.setDocumentFilter(filter);
        panelForm.add(inputValue,
                getConstraints(1, 2, 1, 1, GridBagConstraints.WEST));

        rateLabel = new JLabel(form.getString("interest_rate"));
        rateLabel.setFont(labelFont);
        panelForm.add(rateLabel,
                getConstraints(0, 3, 1, 1, GridBagConstraints.WEST));

        rateValue = new JTextField("0");
        rateValue.setFont(textFont);
        rateValue.setHorizontalAlignment(SwingConstants.RIGHT);
        rateValue.setColumns(15);
        var rateDocument = (AbstractDocument) rateValue.getDocument();
        rateDocument.setDocumentFilter(filter);
        panelForm.add(rateValue,
                getConstraints(1, 3, 1, 1, GridBagConstraints.WEST));

        termLabel = new JLabel(form.getString("term_in_months"));
        termLabel.setFont(labelFont);
        panelForm.add(termLabel,
                getConstraints(0, 4, 1, 1, GridBagConstraints.WEST));

        termValue = new JTextField("0");
        termValue.setFont(textFont);
        termValue.setHorizontalAlignment(SwingConstants.RIGHT);
        termValue.setColumns(15);
        var termDocument = (AbstractDocument) termValue.getDocument();
        termDocument.setDocumentFilter(filter);
        panelForm.add(termValue,
                getConstraints(1, 4, 1, 1, GridBagConstraints.WEST));

        var resultLabel = new JLabel(form.getString("result"));
        resultLabel.setFont(labelFont);
        panelForm.add(resultLabel,
                getConstraints(0, 5, 1, 1, GridBagConstraints.WEST));

        resultValue = new JTextField("0");
        resultValue.setFont(textFont);
        resultValue.setHorizontalAlignment(SwingConstants.RIGHT);
        resultValue.setColumns(15);
        resultValue.setEditable(false);
        resultValue.setBackground(Color.white);
        panelForm.add(resultValue,
                getConstraints(1, 5, 1, 1, GridBagConstraints.WEST));

        add(innerForm, BorderLayout.CENTER);
        add(buildButtonPanel(), BorderLayout.SOUTH);
    }

    /**
     * Creates the title panel from a JPanel with a FlowLayout. This layout
     * places controls one after each other in the JPanel.
     *
     * @return the JPanel with the title
     */
    private JPanel buildTitleBox() {
        var titlePanel = new JPanel(new FlowLayout());
        titleLabel = new JLabel(form.getString("loan_title"));
        titleLabel.setFont(titleFont);
        titlePanel.add(titleLabel, SwingConstants.CENTER);
        return titlePanel;
    }

    /**
     * This constructs a JPanel with a FlowLayout to hold the radio buttons. The
     * three radio buttons are added to a ButtonGroup. It is the ButtonGroup
     * that ensures that only one radio button can be selected.
     *
     * @return JPanel
     */
    private JPanel buildRadioButtonsPanel() {
        var loanButton = new JRadioButton(
                form.getString("loan_radio"));
        loanButton.setFont(labelFont);
        loanButton.setActionCommand("loan");
        loanButton.setSelected(true);

        var savingsButton = new JRadioButton(
                form.getString("savings_radio"));
        savingsButton.setFont(labelFont);
        savingsButton.setActionCommand("savings");

        var goalButton = new JRadioButton(
                form.getString("goal_radio"));
        goalButton.setFont(labelFont);
        goalButton.setActionCommand("goal");

        var radioPanel = new JPanel(new FlowLayout());

        var group = new ButtonGroup();
        group.add(loanButton);
        group.add(savingsButton);
        group.add(goalButton);
        radioPanel.add(loanButton);
        radioPanel.add(savingsButton);
        radioPanel.add(goalButton);

        loanButton.addActionListener(this::radioButtonListener);
        savingsButton.addActionListener(this::radioButtonListener);
        goalButton.addActionListener(this::radioButtonListener);

        return radioPanel;
    }

    /**
     * This construct a JPanel with a FlowLayout to contain the Calculate button
     *
     * @return JPanel
     */
    private JPanel buildButtonPanel() {
        var buttonPanel = new JPanel(new FlowLayout());
        var calculate = new JButton(form.getString("calculate"));
        calculate.setAlignmentX(Component.CENTER_ALIGNMENT);
        calculate.setFont(labelFont);
        calculate.addActionListener(this::calculateButtonHandler);
        buttonPanel.add(calculate, SwingConstants.CENTER);
        var empty = BorderFactory.createEmptyBorder(20, 0, 20, 0);
        buttonPanel.setBorder(empty);
        return buttonPanel;
    }

    /**
     * Listener for the radio buttons. Depending on the radio button selected it
     * sets the calculation type, changes the title, and changes the label for
     * the inputLabel.
     *
     * @param ActionEvent object
     *
     */
    private void radioButtonListener(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "loan" -> {
                titleLabel.setText(form.getString("loan_title"));
                inputLabel.setText(form.getString("loan_amount"));
                calculationType = 0;
            }
            case "savings" -> {
                titleLabel.setText(form.getString("savings_title"));
                inputLabel.setText(form.getString("savings_amount"));
                calculationType = 1;
            }
            case "goal" -> {
                titleLabel.setText(form.getString("goal_title"));
                inputLabel.setText(form.getString("goal_amount"));
                calculationType = 2;
            }
        }
        clearTextFields();
    }

    /**
     * Event handler for when the user press the calculate button
     *
     * @param event An ActionEvent object with details on the event that
     * occured.
     */
    private void calculateButtonHandler(ActionEvent event) {

        convertToZero(); // Convert blank fields to zero

        /*
         * You cannot have a zero in any of the fields
         */
        if ("0".equals(inputValue.getText())
                || "0".equals(rateValue.getText())
                || "0".equals(termValue.getText())) {
            errorAlert(form.getString("calc_msg1"),
                    form.getString("calc_error"));
        } else {
            /*
             * Without binding we need to pass the values enetered by the user
             * to the FinanceData bean.
             */
            financeData.setInputValue(
                    new BigDecimal(inputValue.getText()));
            financeData.setRate(
                    new BigDecimal(rateValue.getText()));
            financeData.setTerm(
                    new BigDecimal(termValue.getText()));
            try {
                switch (calculationType) {
                    case 0 ->
                        calculator.loanCalculation(financeData);
                    case 1 ->
                        calculator.futureValueCalculation(financeData);
                    case 2 ->
                        calculator.savingsGoalCalculation(financeData);
                }
                resultValue.setText(financeData.getResult().toString());
            } catch (ArithmeticException ae) {
                /*
                 * This exception should not occur as we validate the string as
                 * it is entered. We must still be prepared to deal with it
                 * because if a calculation fails in the FinaceCalculations
                 * class it will throw an ArithmeticException
                 */
                errorAlert(form.getString("calc_msg2"), form.getString("calc_error"));
            }
        }
    }

    /**
     * Utility method that converts empty strings to zeros
     */
    private void convertToZero() {
        if ("".equals(inputValue.getText())) {
            inputValue.setText("0");
        }
        if ("".equals(rateValue.getText())) {
            rateValue.setText("0");
        }
        if ("".equals(termValue.getText())) {
            termValue.setText("0");
        }
    }

    /**
     * Shows a JOptionPane dialog box when something goes wrong.
     *
     * @param message The message to display in the dialog
     * @param title The title to display in the dialog
     */
    private void errorAlert(String message, String title) {
        JOptionPane.showMessageDialog(null, message,
                title, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * When the user changes the calculation they wish to carry out this method
     * sets all the fields to zero.
     */
    private void clearTextFields() {
        inputValue.setText("0");
        rateValue.setText("0");
        termValue.setText("0");
        resultValue.setText("0");
    }

    /**
     * Styling the JOptionPane
     */
    private void configureJOptionPane() {
        UIManager.put("OptionPane.messageFont",
                new Font("Verdana", Font.BOLD, 14));
        UIManager.put("OptionPane.buttonFont",
                new Font("Verdana", Font.PLAIN, 12));
        UIManager.put("OptionPane.font",
                new Font("Verdana", Font.PLAIN, 14));
    }

    /**
     * Utility method to simplify the creating of a GridBagConstraints thatis
     * used to control spacioing inside and between componenets in the grid.
     *
     * @param gridx column
     * @param gridy row
     * @param gridwidth number of columns wide
     * @param gridheight number of rows high
     * @param anchor the alignmnet
     * @return GridBagConstraints object
     */
    private GridBagConstraints getConstraints(int gridx, int gridy,
            int gridwidth, int gridheight, int anchor) {
        var c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridwidth;
        c.gridheight = gridheight;
        c.anchor = anchor;
        return c;
    }
}

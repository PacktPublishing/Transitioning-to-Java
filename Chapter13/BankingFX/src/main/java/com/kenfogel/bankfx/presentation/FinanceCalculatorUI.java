package com.kenfogel.bankfx.presentation;

import com.kenfogel.bankfx.business.FinanceCalculations;
import com.kenfogel.bankfx.control.BigDecimalTextField;
import com.kenfogel.bankfx.converter.StringBigDecimalConverter;
import com.kenfogel.bankfx.data.FinanceFXBean;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class builds the user interface and responds to events
 *
 * @author Ken Fogel
 */
public class FinanceCalculatorUI {

    private static final Logger LOG
            = LogManager.getLogger(FinanceCalculatorUI.class);

    private final FinanceCalculations calculator;
    private final FinanceFXBean financeData;

    private BigDecimalTextField inputValue;
    private BigDecimalTextField rateValue;
    private BigDecimalTextField termValue;
    private TextField resultValue;
    private Label inputLabel;
    private Label rateLabel;
    private Label termLabel;
    private Label title;

    private int calculationType;

    private final ResourceBundle form;

    /**
     * Non-default constructor with three parameters
     *
     * @param calculator The business class
     * @param financeData The data class
     * @param form The ResourceBundle for i18n
     */
    public FinanceCalculatorUI(FinanceCalculations calculator,
            FinanceFXBean financeData, ResourceBundle form) {
        this.calculator = calculator;
        this.financeData = financeData;
        this.form = form;
        calculationType = 0; // Loan
    }

    /**
     * This method constructs the user interface returning it as a BorderPane
     * that can be added to a Scene.
     *
     * @return The pane to display
     */
    public BorderPane buildForm() {

        var formPane = new BorderPane();

        formPane.setTop(buildTitleBox());

        var financeGrid = new GridPane();

        inputLabel = new Label(form.getString("loan_amount"));
        inputLabel.setId("prompt_label");
        financeGrid.add(inputLabel, 0, 0);

        inputValue = new BigDecimalTextField();
        inputValue.setId("input_field");
        inputValue.setAlignment(Pos.CENTER_RIGHT);
        financeGrid.add(inputValue, 1, 0);

        rateLabel = new Label(form.getString("interest_rate"));
        rateLabel.setId("prompt_label");
        financeGrid.add(rateLabel, 0, 1);

        rateValue = new BigDecimalTextField();
        rateValue.setId("input_field");
        rateValue.setAlignment(Pos.CENTER_RIGHT);
        financeGrid.add(rateValue, 1, 1);

        termLabel = new Label(form.getString("term_in_months"));
        termLabel.setId("prompt_label");
        financeGrid.add(termLabel, 0, 2);

        termValue = new BigDecimalTextField();
        termValue.setId("input_field");
        termValue.setAlignment(Pos.CENTER_RIGHT);
        financeGrid.add(termValue, 1, 2);

        var resultLabel = new Label(form.getString("result"));
        resultLabel.setId("prompt_label");
        financeGrid.add(resultLabel, 0, 3);

        resultValue = new TextField();
        resultValue.setId("input_field");
        resultValue.setAlignment(Pos.CENTER_RIGHT);
        resultValue.setEditable(false);
        financeGrid.add(resultValue, 1, 3);

        doBinding();

        financeGrid.add(buildButtonPanel(), 0, 4, 2, 1);

        /*
         * The following lines manage the GridPane. It begins by setting the two
         * columns to be a percentage of the overall width of the pane. Padding
         * puts spaces inside each cell in the grid. Hgap and Vgap add space
         * between rows and column.
         */
        var col1 = new ColumnConstraints();
        col1.setPercentWidth(30.0);
        var col2 = new ColumnConstraints();
        col2.setPercentWidth(70.0);

        financeGrid.getColumnConstraints().addAll(col1, col2);

        financeGrid.setPadding(new Insets(20.0));
        financeGrid.setHgap(10.0);
        financeGrid.setVgap(10.0);

        formPane.setCenter(financeGrid);
        clearTextFields();

        return formPane;
    }

    /**
     * This constructs a HBox pane with a label. This label will change based on
     * the selection of a radio button
     *
     * @return A Horizontal Box pane.
     */
    private HBox buildTitleBox() {
        title = new Label(form.getString("loan_title")); // default
        title.setId("title");

        var hbox = new HBox();
        hbox.getChildren().add(title);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(20, 20, 20, 20));

        return hbox;
    }

    private HBox buildButtonPanel() {
        var calculate = new Button(form.getString("calculate"));
        calculate.setOnAction(this::calculateButtonHandler);

        var hbox = new HBox();
        hbox.getChildren().add(calculate);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(20.0));
        return hbox;
    }

    /**
     * This constructs an HBox with three radio buttons first stored in a
     * ToggleGroup. It is the ToggleGroup that ensures that only one radio
     * button can be selected.
     *
     * @return The HBox
     */
    public HBox buildRadioButtonsBox() {

        final var group = new ToggleGroup();

        var rbLoan = new RadioButton(form.getString("loan_radio"));
        rbLoan.setPadding(new Insets(10.0));
        rbLoan.setToggleGroup(group);
        rbLoan.setSelected(true);

        var rbSavings = new RadioButton(form.getString("savings_radio"));
        rbSavings.setPadding(new Insets(10.0));
        rbSavings.setToggleGroup(group);

        var rbGoal = new RadioButton(form.getString("goal_radio"));
        rbGoal.setPadding(new Insets(10.0));
        rbGoal.setToggleGroup(group);

        group.selectedToggleProperty().addListener(
                this::radioButtonListener);

        var hbox = new HBox();
        hbox.getChildren().addAll(rbLoan, rbSavings, rbGoal);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(20.0));

        return hbox;
    }

    /**
     * Listener for the radio buttons. Depending on the radio button selected it
     * sets the calculation type, changes the title, and changes the label for
     * the inputLabel.
     *
     * @param observableView A reference to the object that generated the event
     * @param oldToggle A reference to the RadioButton before there was change
     * @param newToggle A reference to the RadioButton after there was change
     */
    private void radioButtonListener(
            ObservableValue<? extends Toggle> observableView,
            Toggle oldToggle, Toggle newToggle) {
        /*
         * We only care about what the user selected so we use the newToggle to
         * get a reference to the button you selected.
         */
        var rb = (RadioButton) newToggle.getToggleGroup().getSelectedToggle();

        switch (rb.getText()) {
            case "Loan" -> {
                calculationType = 0;
                title.setText(form.getString("loan_title"));
                inputLabel.setText(form.getString("loan_amount"));
            }
            case "Savings" -> {
                calculationType = 1;
                title.setText(form.getString("savings_title"));
                inputLabel.setText(form.getString("savings_amount"));
            }
            case "Goal" -> {
                calculationType = 2;
                title.setText(form.getString("goal_title"));
                inputLabel.setText(form.getString("goal_amount"));
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

        convertToZero();
        /*
         * You cannot have a zero in any of the fields
         */
        if ("0".equals(inputValue.getText())
                || "0".equals(rateValue.getText())
                || "0".equals(termValue.getText())) {
            errorAlert(form.getString("calc_msg1"), form.getString("calc_error"));
        } else {
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
                 * This ArithmeticException will occur if a user enters a decimal point and nothing else in a text field.
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
     * Shows a Alert box when something goes wrong.
     *
     * @param message The message to display in the Alert
     * @param title The title to display in the Alert
     */
    private void errorAlert(String message, String title) {
        var alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.getDialogPane().getStylesheets().
                add("/styles/Styles.css");
        alert.showAndWait();
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
     * This binds each TextField with a property in the FinanceFXBean. It uses
     * the convert object as a custom converter.
     */
    private void doBinding() {
        var convert = new StringBigDecimalConverter();
        Bindings.bindBidirectional(inputValue.textProperty(),
                financeData.inputValueProperty(), convert);
        Bindings.bindBidirectional(rateValue.textProperty(),
                financeData.rateProperty(), convert);
        Bindings.bindBidirectional(termValue.textProperty(),
                financeData.termProperty(), convert);
        Bindings.bindBidirectional(resultValue.textProperty(),
                financeData.resultProperty(), convert);
    }
}

package com.kenfogel.bankfx;

import com.kenfogel.bankfx.business.FinanceCalculations;
import com.kenfogel.bankfx.data.FinanceFXBean;
import com.kenfogel.bankfx.presentation.FinanceCalculatorUI;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class sets up the JavaFX application.
 *
 * @author Ken Fogel
 */
public class FinanceCalculatorMain extends Application {

    // I add this line to most every file I write so that should I need to 
    // log something I can.
    private static final Logger LOG
            = LogManager.getLogger(FinanceCalculatorMain.class);

    private FinanceCalculations calculator;
    private FinanceFXBean financeData;
    private FinanceCalculatorUI gui;
    private ResourceBundle form;

    /**
     * This is an optional method that you can override from the super class
     * Application. It is playing a role similar to a constructor but as it is
     * called after the object is created it has full access to the JavaFX
     * framework
     */
    @Override
    public void init() {
        calculator = new FinanceCalculations();
        financeData = new FinanceFXBean();
        // This line is optional. You can remove it and the locale 
        // reference when loading the resource bundle.The Locale will 
        // then come from thje JVM.
        Locale locale = new Locale("en", "CA");
        // Load the appropriate messages file
        form = ResourceBundle.getBundle("MessagesBundle", locale);
        gui = new FinanceCalculatorUI(calculator, financeData, form);
    }

    /**
     * This method must be overriden. It recieves a reference to the Stage that
     * is created by the Application super class.
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        var root = new BorderPane();
        root.setTop(gui.buildRadioButtonsBox());
        root.setCenter(gui.buildForm());

        var scene = new Scene(root, 620, 450);
        // Load the stylesheet
        scene.getStylesheets().add("styles/Styles.css");

        primaryStage.setTitle(form.getString("title"));
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        /*
         * You do not use System.exit() in a JavavFX app. You use
         * Platform.exit(). This calls Platform.exit if the user closes the
         * program by clicking on the X in the title bar.
         */
        primaryStage.setOnCloseRequest(e -> {
            Platform.exit();
        });
        primaryStage.show();
    }

    /**
     * In a JavaFX application you need only this one line of code in main
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}

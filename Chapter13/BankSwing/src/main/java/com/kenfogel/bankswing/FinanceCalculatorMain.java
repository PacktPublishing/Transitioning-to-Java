package com.kenfogel.bankswing;

import com.kenfogel.bankswing.business.FinanceCalculations;
import com.kenfogel.bankswing.data.FinanceBean;
import com.kenfogel.bankswing.presentation.*;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.SwingUtilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.JFrame;
// You can extend either of these two to see how they differ from each other.
// import javax.swing.JWindow;
// import javax.swing.JDialog;

/**
 * This class sets up the Swing application.
 *
 * @author Ken Fogel
 */
public class FinanceCalculatorMain extends JFrame {

    private static final Logger LOG
            = LogManager.getLogger(FinanceCalculatorMain.class);

    private final FinanceBean financeData;
    private final FinanceCalculations calculator;
    private FinanceCalculatorUI gui;

    /**
     * Default constructor that instantiates the business and data class objects
     */
    public FinanceCalculatorMain() {
        calculator = new FinanceCalculations();
        financeData = new FinanceBean();
    }

    /**
     * This method is user defined, it could have any name. It constructs the
     * JFrame that this class extends.
     */
    public void start() {
        /*
         * This line is optional. You can remove it and the locale reference
         * when loading the resource bundle.The Locale will then come from the
         * JVM.
         */
        Locale locale = new Locale("en", "CA");
        // Load the appropriate messages file
        var form = ResourceBundle.getBundle(
                "MessagesBundle", locale);

        gui = new FinanceCalculatorUI(calculator,
                financeData, form);
        gui.buildFormPanel();
        setContentPane(gui);

        // Comment out if using JDialog or JWindow
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Use this call just for JDialog
        // frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        // Comment out if using JWindow        
        setTitle(form.getString("title"));
        setSize(620, 450);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * The main method uses invokeLater to run the Swing app in the AWT Event
     * dispatcher thread. This is the preferred way to start a Swing
     * appplication.
     *
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var frame = new FinanceCalculatorMain();
            frame.start();
        });
    }
}

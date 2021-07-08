package currencyapp;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @filename CurrencyGUI.java
 * @author Stephen Snelling
 * @date 6/23/2021
 * 
 * This class CurrencyGUI extends JFrame and represents the GUI for Group 4's currency
 * conversion application. It allows the user to enter a positive float value, and 
 * convert that value from one currency to another. The user selects the starting and
 * ending currency types.
 */

public class CurrencyGUI extends JFrame {

    // Represents the current list of currencies our app uses
    private final String[] currencies = {"US Dollar", "Euro", "British Pound", 
                                         "Indian Rupee", "Australian Dollar", "Canadian Dollar",
                                         "Singapore Dollar", "Swiss Franc", "Malaysian Ringgit",
                                         "Japanese Yen", "Chinese Yuan Renminbi"};
    
    private JButton convertButton;
    private JTextField amountTextField, resultTextField;
    private JLabel amountLabel, resultLabel;
    private JComboBox<String> fromCurrencyJComboBox, toCurrencyJComboBox;
    private CurrencyManager currencyManager;
    
    // Constructor
    public CurrencyGUI() {
        initComponents();
    } // end constructor
    
    // Adds all components to frame, and does the Layout logic
    private void initComponents() {
        setSize(400, 210);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Group 4 Currency Conversion App");
        setResizable(false);
        currencyManager = new CurrencyManager();
        
        // initialize Components
        convertButton =         new JButton("Convert");
        convertButton.addActionListener((ActionEvent evt) -> {
            convertAction(evt);
        });
        amountTextField =       new JTextField(20);
        resultTextField =       new JTextField(20);
        resultTextField.setEditable(false);
        amountLabel =           new JLabel("Amount to Convert: ");
        resultLabel =           new JLabel("Converted Amount: ");
        fromCurrencyJComboBox = new JComboBox(currencies);
        toCurrencyJComboBox =   new JComboBox(currencies);
        
        // create a JPanel to hold components
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 5);
        contentPanel.setLayout(layout);
        
        // Panel to hold fromCurrencyJComboBox
        JPanel fromCurrencyPanel = new JPanel();
        fromCurrencyPanel.setBorder(BorderFactory
                .createTitledBorder(BorderFactory.createEtchedBorder(), "From"));
        fromCurrencyPanel.add(fromCurrencyJComboBox);
        
        // Panel to hold toCurrencyJComboBox
        JPanel toCurrencyPanel = new JPanel();
        toCurrencyPanel.setBorder(BorderFactory
                .createTitledBorder(BorderFactory.createEtchedBorder(), "To"));
        toCurrencyPanel.add(toCurrencyJComboBox);
        
        // Panel to organize the above panels
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.LINE_AXIS));
        optionsPanel.add(fromCurrencyPanel);
        optionsPanel.add(toCurrencyPanel);
        
        // Panel to hold resultLabel and resultTextField
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(layout);
        resultPanel.add(resultLabel);
        resultPanel.add(resultTextField);
        
        // Add all components to the contentPanel
        contentPanel.add(amountLabel);
        contentPanel.add(amountTextField);
        contentPanel.add(optionsPanel);
        contentPanel.add(convertButton);
        contentPanel.add(resultPanel);
        
        // add contentPanel to frame and set visible
        add(contentPanel);
        setVisible(true);
    } // end of initComponents
    
    // This method listens for the Convert Button action listener and converts an
    // entered amount from one currency to another based on user selections.
    private void convertAction(ActionEvent evt) {
        String fromCurrency = (String)fromCurrencyJComboBox.getSelectedItem();
        String toCurrency = (String)toCurrencyJComboBox.getSelectedItem();
        
        // Try to convert the entered amount using CurrencyManager.convert(), throwing
        // an error if the entered amount is null, a non-number, or a negative number.
        try {
            float amount = Float.parseFloat(amountTextField.getText());
            if(amount < 0)
                throw new NumberFormatException();
            float result = currencyManager.convert(fromCurrency, toCurrency, amount);
            resultTextField.setText(Float.toString(result));
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Make sure to enter an amount first!");
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Entered amount must be a positive "
                                                + "number!");
        }
    } // end method convertAction
    
    public static void main(String[] args) {
        new CurrencyGUI();
    } // end of main method
    
} // end of class CurrencyGUI

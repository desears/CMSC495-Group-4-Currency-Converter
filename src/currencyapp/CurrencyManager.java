package currencyapp;

import java.util.HashMap;

/*
* Author: Ronald DeSears
* Course/Group: UMGC CMSC 495 Group 4
* Description: This class accepts rate retrieval from the ExchangeRateWebService
* formatted in an ArrayList of objects and retrieves online exchange rates for the
* Top 11 currencies.  This class also executes the "conversion" method activated
* from the GUI.
*/

public class CurrencyManager {

    HashMap<String, Currency> currencies;
    
    // Constructor
    public CurrencyManager() {
        currencies = ExchangeRateWebService.retrieveRates();
    }
    
    // This method converts an amount of currency1 to currency2 sourced from online
    // rates
    public float convert(String currency1, String currency2, float amount) {
        
        // if both currencies are the same, no conversion required, return amount
        if(currency1.equals(currency2)) {
            return amount;
        }
        
        // if the starting currency is not USD, we need to convert the amount to USD
        // first in order to convert to currency2 since our rates are USD based
        // This is done  by dividing amount/USDRate
        if (!currency1.equals("US Dollar")) {
            amount /= currencies.get(currency1).getRate();
        }
        
        return amount * (float) currencies.get(currency2).getRate();
    } // end of method convert

} // end of class CurrencyManager

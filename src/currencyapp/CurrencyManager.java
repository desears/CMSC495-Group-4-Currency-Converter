package currencyapp;

import java.util.ArrayList;

/*
* Author: Ronald DeSears
* Course/Group: UMGC CMSC 495 Group 4
* Description: This class accepts rate retrieval from the ExchangeRateWebService
* formatted in an ArrayList of objects and retrieves online exchange rates for the
* Top 11 currencies.  This class also executes the "conversion" method activated
* from the GUI.
*/

public class CurrencyManager {
    String curr;
    ArrayList <Currency> newC;
    Currency c;
    float m;
    float newAmount;
    
    // placeholder
    public float convert(String currency1, String currency2, float amount) {
        m = 0;
        newAmount = amount;
        ExchangeRateWebService rate = new ExchangeRateWebService();
        rate.retrieveRates();
        newC = rate.retrieveRates();
        curr = currency2;
        
    switch (currency1) { 
        case "US Dollar":
            searchRates();
        break;
        case "Euro":
            convertUSD("EUR");
            searchRates();
            break;
        case "British Pound":
            convertUSD("GBP");
            searchRates();
            break;
        case "Indian Rupee":
            convertUSD("INR");
            searchRates();
            break;
        case "Australian Dollar":
            convertUSD("AUD");
            searchRates();
            break;
        case "Canadian Dollar":
            convertUSD("CAD");
            searchRates();
            break;
        case "Singapore Dollar":
            convertUSD("SGD");
            searchRates();
            break;
        case "Swiss Franc":
            convertUSD("CHF");
            searchRates();
            break;
        case "Malaysian Ringgit":
            convertUSD("MYR");
            searchRates();
            break;
        case "Japanese Yen":
            convertUSD("JPY");
            searchRates();
            break;
        case "Chinese Yuan Renminbi":
            convertUSD("CNY");
            searchRates();
            break;
    }
        return newAmount;
    }
        public void convertUSD(String u) {
            for (int i = 0; i<newC.size(); i++) {
                    if(newC.get(i).toString().contains(u)) {
                    Currency c = newC.get(i);
                    newAmount = newAmount/(float) c.getRate();
                    //System.out.println(c.getRate());
                    //System.out.println(c.toString());
                    System.out.println(newAmount);
                    }
                }
        }
        public void searchRates() {
        if(curr == "US Dollar") {    
            for (int i = 0; i<newC.size(); i++) {
                if(newC.get(i).toString().contains("USD")) {
                Currency c = newC.get(i);
                m = (float) c.getRate();
                newAmount = m*newAmount;
                System.out.println(c.getRate());
                System.out.println(c.toString());
                System.out.println(m);
                }
            }
        }    
        if(curr == "Euro") {    
            for (int i = 0; i<newC.size(); i++) {
                if(newC.get(i).toString().contains("EUR")) {
                Currency c = newC.get(i);
                m = (float) c.getRate();
                newAmount = m*newAmount;
                System.out.println(c.getRate());
                System.out.println(c.toString());
                System.out.println(m);
                }
            }
        }
        else if(curr == "British Pound") {
            for (int i = 0; i<newC.size(); i++) {
                if(newC.get(i).toString().contains("GBP")) {
                Currency c = newC.get(i);
                m = (float) c.getRate();
                newAmount = m*newAmount;
                System.out.println(c.getRate());
                System.out.println(c.toString());
                }
            }
        }
        else if(curr == "Indian Rupee") {
            for (int i = 0; i<newC.size(); i++) {
                if(newC.get(i).toString().contains("INR")) {
                Currency c = newC.get(i);
                m = (float) c.getRate();
                newAmount = m*newAmount;
                System.out.println(c.getRate());
                System.out.println(c.toString());
                }
            }
        }
        else if(curr == "Australian Dollar") {
            for (int i = 0; i<newC.size(); i++) {
                if(newC.get(i).toString().contains("AUD")) {
                Currency c = newC.get(i);
                m = (float) c.getRate();
                newAmount = m*newAmount;
                System.out.println(c.getRate());
                System.out.println(c.toString());
                }
            }
        }
        else if(curr == "Canadian Dollar") {
            for (int i = 0; i<newC.size(); i++) {
                if(newC.get(i).toString().contains("CAD")) {
                Currency c = newC.get(i);
                m = (float) c.getRate();
                newAmount = m*newAmount;
                System.out.println(c.getRate());
                System.out.println(c.toString());
                }
            }
        }
        else if(curr == "Singapore Dollar") {
            for (int i = 0; i<newC.size(); i++) {
                if(newC.get(i).toString().contains("SGD")) {
                Currency c = newC.get(i);
                m = (float) c.getRate();
                newAmount = m*newAmount;
                System.out.println(c.getRate());
                System.out.println(c.toString());
                }
            }
        }
        else if(curr == "Swiss Franc") {
            for (int i = 0; i<newC.size(); i++) {
                if(newC.get(i).toString().contains("CHF")) {
                Currency c = newC.get(i);
                m = (float) c.getRate();
                newAmount = m*newAmount;
                System.out.println(c.getRate());
                System.out.println(c.toString());
                }
            }
        }
        else if(curr == "Malaysian Ringgit") {
            for (int i = 0; i<newC.size(); i++) {
                if(newC.get(i).toString().contains("MYR")) {
                Currency c = newC.get(i);
                m = (float) c.getRate();
                newAmount = m*newAmount;
                System.out.println(c.getRate());
                System.out.println(c.toString());
                }
            }
        }
        else if(curr == "Japanese Yen") {
            for (int i = 0; i<newC.size(); i++) {
                if(newC.get(i).toString().contains("JPY")) {
                Currency c = newC.get(i);
                m = (float) c.getRate();
                newAmount = m*newAmount;
                System.out.println(c.getRate());
                System.out.println(c.toString());
                }
            }
        }
        else if(curr == "Chinese Yuan Renminbi") {
            for (int i = 0; i<newC.size(); i++) {
                if(newC.get(i).toString().contains("CNY")) {
                Currency c = newC.get(i);
                m = (float) c.getRate();
                newAmount = m*newAmount;
                System.out.println(c.getRate());
                System.out.println(c.toString());
                }
            }
        }
    }
    
}

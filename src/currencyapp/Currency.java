package currencyapp;

/*
* Author: Roy Auh
* Course/Group: UMGC CMSC 495 Group 4
* Description: This class specifies the currency object that holds the currency code
* and rate, with USD(US Dollar) being 1.
*/

public class Currency {
    private final String currencyCode;
    private final Double rate;

    public Currency(String currencyCode, Double rate) {
        this.currencyCode = currencyCode;
        this.rate = rate;
    }
    
    public String getCurrencyCode() {
        return currencyCode;
    }
    
    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyCode='" + currencyCode + '\'' +
                ", rate=" + rate +
                '}';
    }
}

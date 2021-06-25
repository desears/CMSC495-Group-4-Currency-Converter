package currencyapp;

/*
* Author: Roy Auh
* Course/Group: UMGC CMSC 495 Group 4
* Description: This class specifies the currency object that holds the currency code (name) and its rate, based on USD being 1.
*/

public class Currency {
    private String name;
    private Double rate;

    public Currency(String n, Double r) {
        this.name = n;
        this.rate = r;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }
}

package currencyapp;

/*
 * Author: Roy Auh
 * Course/Group: UMGC CMSC 495 Group 4
 * Description: This class calls the exchange-rate API to retrieve a JSON string containing the conversion rates
 * for all currencies, and creates Currency objects of the specified top 10 most commonly used currencies.
 * If there is a connectivity problem with the web API, an arraylist of back-up rates is returned.
 * Those rates are from June 25, 2021.
 */

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ExchangeRateWebService {

    private static final String webUrl = "https://v6.exchangerate-api.com/v6/1dc8c170db97f09405c85b57/latest/USD";


    public static ArrayList<Currency> retrieveRates() {
        ArrayList<Currency> currencies = new ArrayList<>();

        try {
            URL openURL = new URL(webUrl);
            URLConnection urlConnect = openURL.openConnection();
            urlConnect.setConnectTimeout(750);
            urlConnect.setReadTimeout(750);
            BufferedReader inReader = new BufferedReader(new InputStreamReader(urlConnect.getInputStream()));

            JSONParser jsonParser = new JSONParser();
            String s;

            while ((s=inReader.readLine()) != null) {
                JSONObject object = (JSONObject) jsonParser.parse(s);
                JSONObject rates = (JSONObject) object.get("conversion_rates");

                currencies.add(new Currency("USD", 1.00));
                currencies.add(new Currency("EUR", (Double) rates.get("EUR")));
                currencies.add(new Currency("GBP", (Double) rates.get("GBP")));
                currencies.add(new Currency("INR", (Double) rates.get("INR")));
                currencies.add(new Currency("AUD", (Double) rates.get("AUD")));
                currencies.add(new Currency("CAD", (Double) rates.get("CAD")));
                currencies.add(new Currency("SGD", (Double) rates.get("SGD")));
                currencies.add(new Currency("CHF", (Double) rates.get("CHF")));
                currencies.add(new Currency("MYR", (Double) rates.get("MYR")));
                currencies.add(new Currency("JPY", (Double) rates.get("JPY")));
                currencies.add(new Currency("CNY", (Double) rates.get("CNY")));
            }

            // for (Currency c : currencies) { System.out.println(c); }


        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(null,
                    "Problem encountered retrieving data from the web service",
                    "Connection Problem", JOptionPane.WARNING_MESSAGE);
            return getBackUpRates();
        }

        return currencies;
    }

    public static ArrayList<Currency> getBackUpRates() {
        ArrayList<Currency> currencies = new ArrayList<>();

        currencies.add(new Currency("USD", 1.00));
        currencies.add(new Currency("EUR", 0.8364));
        currencies.add(new Currency("GBP", 0.7179));
        currencies.add(new Currency("INR", 74.1667));
        currencies.add(new Currency("AUD", 1.3186));
        currencies.add(new Currency("CAD", 1.2287));
        currencies.add(new Currency("SGD", 1.3425));
        currencies.add(new Currency("CHF", 0.9181));
        currencies.add(new Currency("MYR", 4.1591));
        currencies.add(new Currency("JPY", 110.8417));
        currencies.add(new Currency("CNY", 6.4708));

        return currencies;
    }
}

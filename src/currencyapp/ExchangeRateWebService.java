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

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class ExchangeRateWebService {

    private static final String webUrl = "https://v6.exchangerate-api.com/v6/dadc1537fed255738ca53d0b/latest/USD";


    public static HashMap<String, Currency> retrieveRates() {
        HashMap<String, Currency> currencies = new HashMap<>();

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
                JSONObject rates = (JSONObject) object.get("conversion_rates");     // only retrieve the rates from the JSON object
                
                // get top 11 most commonly used currencies into Currency objects
                currencies.put("US Dollar", new Currency("USD", 1.00));
                currencies.put("Euro", new Currency("EUR", (Double) rates.get("EUR")));
                currencies.put("British Pound", new Currency("GBP", (Double) rates.get("GBP")));
                currencies.put("Indian Rupee", new Currency("INR", (Double) rates.get("INR")));
                currencies.put("Australian Dollar", new Currency("AUD", (Double) rates.get("AUD")));
                currencies.put("Canadian Dollar", new Currency("CAD", (Double) rates.get("CAD")));
                currencies.put("Singapore Dollar", new Currency("SGD", (Double) rates.get("SGD")));
                currencies.put("Swiss Franc", new Currency("CHF", (Double) rates.get("CHF")));
                currencies.put("Malaysian Ringgit", new Currency("MYR", (Double) rates.get("MYR")));
                currencies.put("Japanese Yen", new Currency("JPY", (Double) rates.get("JPY")));
                currencies.put("Chinese Yuan Renminbi", new Currency("CNY", (Double) rates.get("CNY")));
                
            }

        } catch (IOException | ParseException e) {  // if error, then call back-up rates
            JOptionPane.showMessageDialog(null,
                    "Problem encountered retrieving data from the web service",
                    "Connection Problem", JOptionPane.WARNING_MESSAGE);
            System.out.print("API access failed. ");
            return getBackUpRates();
        }

        return currencies;
    }

    
    // method to call when web service is unavailable
    // this will specify the back-up rates based on rates on June 25, 2021
    private static HashMap<String, Currency> getBackUpRates() {
        HashMap<String, Currency> currencies = new HashMap<>();

        currencies.put("US Dollar", new Currency("USD", 1.00));
        currencies.put("Euro", new Currency("EUR", 0.8364));
        currencies.put("British Pound", new Currency("GBP", 0.7179));
        currencies.put("Indian Rupee", new Currency("INR", 74.1667));
        currencies.put("Australian Dollar", new Currency("AUD", 1.3186));
        currencies.put("Canadian Dollar", new Currency("CAD", 1.2287));
        currencies.put("Singapore Dollar", new Currency("SGD", 1.3425));
        currencies.put("Swiss Franc", new Currency("CHF", 0.9181));
        currencies.put("Malaysian Ringgit", new Currency("MYR", 4.1591));
        currencies.put("Japanese Yen", new Currency("JPY", 110.8417));
        currencies.put("Chinese Yuan Renminbi", new Currency("CNY", 6.4708));
        
        return currencies;
    }
}

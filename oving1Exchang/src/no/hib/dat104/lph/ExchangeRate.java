package no.hib.dat104.lph;

import java.io.IOException;

/**
     {"success":true,
		"source":"USD",
		"target":"EUR",
		"rate":"0.8996300",
		"amount":0.9,
		"message":""}
 */
public class ExchangeRate {

    boolean success;
	String source;
	String target;
	double rate;
	double amount;
	String message;
	
	public static void main(String[] args) {
		try {
			System.out.println(ExchangeRateService.getRate("NOK", "USD"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

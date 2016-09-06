package no.hib.dat104;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Regnom {

	public static String regn(String amount, Double rate, String source, String target) {
		NumberFormat formater = new DecimalFormat("#0.0");
		double veksletBelop=Double.parseDouble(amount) * rate ;

		
		return ""+formater.format(Double.parseDouble(amount)) + " "+ source +" blir "+ formater.format(veksletBelop) +" "+ target;

	}
	


	public static boolean validate(String amount){
		boolean sant=true;
		
		sant= (amount.matches("^-?\\d+\\.?\\d*$"))?true:false;
			
		
		//		 try {
		//	            Double.parseDouble(tempInndata);
		//	            return true;
		//	        } catch (NumberFormatException e) {
		//	            return false;
	//	        }
	return sant;
	}
	
}

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Regnom {

	public static String regn(String tempInndata, String valg) {
		String Res="";

		NumberFormat formater = new DecimalFormat("#0.0");

	

		double temp=Double.parseDouble(tempInndata);
		switch (valg) {
		case "1":
			
			
			Res =(formater.format(Double.parseDouble(tempInndata))) +  " \u00b0  C = "+formater.format((temp * (9./5.))+32 ) +"\u00b0 F";
			break;
		case "2":
			Res = (formater.format(Double.parseDouble(tempInndata))) +"\u00b0 F = "+formater.format( (temp - 32) / (5./9.) ) +"\u00b0 C";

			break;

		default:
			break;
		}

		return Res;

	}



	public static boolean validate(String tempInndata, String valg){
		boolean sant=false;
		
		if (tempInndata.matches("^-?\\d+\\.?\\d*$")) {
			
			if (valg.equals("1")) {
				sant=(Double.parseDouble(tempInndata)>= -273.15)?true:false;
			}else {
				sant=(Double.parseDouble(tempInndata)>= -459.67)?true:false;
			}
		}
		
		
		//		 try {
		//	            Double.parseDouble(tempInndata);
		//	            return true;
		//	        } catch (NumberFormatException e) {
		//	            return false;
	//	        }
	return sant;
	}
	
}

package learning.rnd.format;

import java.text.DecimalFormat;

public class DecimalFormatTest {

	public static void main(String [] args) {
		DecimalFormat format = new DecimalFormat("0.00");
		System.out.println(format.format(new Double(12.5)));
		
		Double doub = new Double(55.5); 
		double val = (100 - 25.00)/100.0;
		double result = (doub.doubleValue()*val);
		int digit = (int)(result*100);
		double truncated = digit/100.0;
		double quick = (int)(result*100)/100.0;
		System.out.println("Value "+val);
		System.out.println("Original "+result);
		System.out.println("Formatted "+String.format("%,.2f",result));
		System.out.println("Original Truncated "+digit);
		System.out.println("Formatted Truncated "+String.format("%,.2f",truncated));
		System.out.println("quick "+quick);
		
	}
	
}

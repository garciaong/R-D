package learning.rnd.regexp;

public class RegularExpression {

	public static void main(String [] args) {
//		boolean result = "idiot-test@ A/L o'riginal".matches("[ a-zA-Z]+$");
//		boolean result = "idiot's-@ A/L o".matches("[ a-zA-Z'/@-]+$");
//		System.out.println("Result : "+result);
		
		String pattern = "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?";
		System.out.println("Result : "+"abc@gmailA.com.my".matches(pattern));
//		String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//		System.out.println("Result : "+"Aabc@gmail.com.my".matches(pattern));
	}
	
}

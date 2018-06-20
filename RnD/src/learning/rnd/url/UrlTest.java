package learning.rnd.url;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class UrlTest {

	private final static String USER_AGENT = "Chrome/43.0.2357.65";
	
	public static void main(String [] args) throws IOException {
//		URL obj = new URL("http://uat.etiqa.com.my:4441/getonline/sites/REST/controller/SWTCInsurancepdfController/ExtWtcPdsFile?lang=lan_en");
		URL obj = new URL("https://uat.etiqa.com.my:4442/getonline/swtcqq1");
//		URL obj = new URL("https://www.etiqa.com.my/getonline/sites/REST/controller/SWTCInsurancepdfController/WtcPdsFile");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
		
		int responseCode = con.getResponseCode();
		System.out.println("Response Code : " + responseCode);
	}
	
}

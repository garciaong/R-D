package learning.rnd.swtc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

public class CpfRestfulWebService {

	public static void main(String [] args) {
		getQuotation();
	}
	
	
	private static void getQuotation() {
		RestTemplate rt = new RestTemplate();
		MultiValueMap<String, Object> mapInput = new LinkedMultiValueMap<String, Object>();
		Map<String,Object> premiumMap = new HashMap<String,Object>();
		
		mapInput.add("destinationCodeArea", "WU");
		mapInput.add("travelwithTypeId", "W01");			
		mapInput.add("triptype", "singl");
		mapInput.add("startDate", "05/02/2018");
		mapInput.add("endDate", "05/02/2018");
		
		String json = rt.postForObject("http://172.29.124.1:7011/SimpWTC-CPF/getPlanPremium",
				mapInput,String.class);
		
		Gson gson = new Gson();			
		premiumMap = (Map<String,Object>) gson.fromJson(json, premiumMap.getClass());
		
		System.out.println("Response : \n"+json);
	}
	
}

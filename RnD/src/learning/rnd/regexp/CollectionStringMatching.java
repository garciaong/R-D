package learning.rnd.regexp;

import java.util.ArrayList;
import java.util.List;

public class CollectionStringMatching {

	public static void main(String [] args) {
		List<String> arrayList = new ArrayList<String>();
		arrayList.add("abc");
		arrayList.add("def");
		arrayList.add("ghi");
		boolean hasAlphabet = false;
		
		for(String value:arrayList) {
			hasAlphabet = value.contains("x");
			if(hasAlphabet)break;
		}
		System.out.println("Contains e? "+hasAlphabet+" array string "+arrayList.toString());
		
		arrayList.remove(0);
		
		System.out.println("After remove "+arrayList.toString()+" size "+arrayList.size()+" index 0 "+arrayList.get(0));
		
		List<String> arrayList2 = new ArrayList<String>();
		arrayList2.add("abc");
		arrayList.addAll(arrayList2);
		System.out.println("After add "+arrayList.toString());
	}
	
}

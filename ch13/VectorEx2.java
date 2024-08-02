package ch13;

import java.util.Vector;

public class VectorEx2 {
	public static void main(String[] args) {
		String city[] = {"노르웨이","스위스","뉴질랜드","덴마크","캐나다"};
		Vector vec1 =new Vector();
		Vector<String> vec2 =new Vector<String>();
		for (int i = 0; i < city.length; i++) {
			vec1.add(city[i]);
			vec2.add(city[i]);
		}
		for (int i = 0; i < vec1.size(); i++) {
			String s1 = (String)vec1.get(i);
			String s2 = vec2.get(i);
			System.out.println(s1 +":"+ s2);
		}
		for (Object obj : vec1) {
			
		}
		for (String string : vec2) {
			
		}
	}
}

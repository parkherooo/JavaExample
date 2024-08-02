package ch11;

public class StringEx2 {
	public static void main(String[] args) {
		String str ="Java Programming";
		//str+="!!!";
		System.out.println(str);
		int len = str.length();
		System.out.println("len : "+ len);
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		
		String str2= str.substring(5);
		String str3= str.substring(5,10);
		System.out.println(str2);
		System.out.println(str3);
		
		//8번째 문자
		char c1 =str.charAt(8);
		System.out.println(c1);
		
		//짝수 문자만 출력
		for (int i = 0; i < len; i++) {
			if(i%2==0) {
				System.out.print(str.charAt(i));
			}
		}//-for
		System.out.println();
		//첫번째 a 문자 위치값
		int idx1= str.indexOf('a');
		System.out.println(idx1);
		
		//마지막 a 문자 위치값
		int idx2 = str.lastIndexOf('a');
		System.out.println(idx2);
		
		//없는 문자 값
		int idx3 = str.indexOf('z');
		System.out.println(idx3);
		
		//a 를 q로 변환출력
		for (int i = 0; i < len; i++) {
			if(str.charAt(i)=='a') {
				System.out.print('q');
			} else {
				System.out.print(str.charAt(i));
			}//--if else
		}//--for
		System.out.println();
		String str4 = str.replace('a', 'q');
		System.out.println(str4);

		//str 반대로 출력
		for (int i = len-1; i > -1; i--) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb.reverse());
		
		//특정 토큰 문자로 단어를 쪼갬
		String str5 =  "Java&JSP&Flutter&Iot&Spring";
		String str6[] = str5.split("&");
		for (int i = 0; i < str6.length; i++) {
			System.out.println(str6[i]);
		}//--for
		
		//공백제거
		String str7 = "       JSPStudy           ";
		System.out.println("***"+str7.trim()+"*****");
		
		int idx4= 35;
		//정수->문자열 
		String str8 = String.valueOf(idx4);
		String str9 = idx4+"";//<--꼼수
		System.out.println(str8);
		System.out.println(str9);
	}
}

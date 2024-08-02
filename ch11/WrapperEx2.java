package ch11;

public class WrapperEx2 {
	public static void main(String[] args) {
		char c1 = 'J'; //문자인지 
		if(Character.isLetter(c1))
			System.out.println(c1+ " : 문자입니다.");
		
		char c2 = 'a'; //소문자인지아닌지
		if(Character.isLowerCase(c2))
			System.out.println(c2 + " : 소문자입니다.");
		
		char c3 = '2'; //숫자인지
		if(Character.isDigit(c3))
			System.out.println(c3+" : 숫자입니다.");
		
		char c4 = ' '; //공백인지
		if(Character.isWhitespace(c4))
			System.out.println(c4+" : 공백입니다.");
		
		Byte bt;
		Short s;
		Integer i;
		Long l;
		
		Float f;
		Double d;
		
		Character c;
		Boolean b;
		
	}
}

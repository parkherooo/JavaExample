package ch11;

import java.util.Vector;

public class WrapperEx1 {

	public static void main(String[] args) {
		//byte, short, int, long
		//float , double
		//char, boolean
		int a = 10;
		//Auto Boxing
		Integer i = a;
		//Auto unBoxing
		int b= i;
		Vector v= new Vector();
		v.add(new String("aaa"));
		v.add(new Object());
		v.add(a); //Auto Boxing <-Integer 타입으로 저장
		int c = /*Auto unBoxing*/(Integer)v.get(2);
		System.out.println(c);
		
		Integer i1 = new Integer(a);
		Integer i2 = new Integer("22");		
		Integer i3 = Integer.valueOf(a);		
		Integer i4 = Integer.valueOf("22");		
		int d = i4.intValue(); //Auto Boxing 사용하지 않으면 이렇게 사용
		//숫자형태의 문자열을 int로 변환
		int e = Integer.parseInt("23");
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.toBinaryString(e))	;
		System.out.println(Integer.toOctalString(e));
		System.out.println(Integer.toHexString(e));
		
		//반지름이 s1인 원의 넓이
		String s1 = "3.14";
		double d1 = Double.parseDouble(s1);
		System.out.println(d1*d1*Math.PI);
	}

}

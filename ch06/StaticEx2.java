package ch06;

import common.util.StringUtil;

class Static2{
	static int a;
	int b;
}

public class StaticEx2 {
	public static void main(String[] args) {
		Static2 st1 = new Static2();
		Static2 st2 = new Static2();
		//static 변수는 모든 객체의 공통적을 사용하기 위해 히니민 만들어짐. 
		st1.a=10;
		st1.b=10;
		st2.a=20;
		st2.b=20;
		System.out.println("st1 : "+(st1.a+st1.b)); 
		System.out.println("st2 : "+(st2.a+st2.b));
		String str ="100000000";
		System.out.println(StringUtil.addComma(str));
	}
}

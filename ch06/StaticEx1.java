package ch06;

/*static : 필드, 메소드,클래스(조건)
 * 필드 및 메소드 : 객체 생성없이 클래스명으로 JVM 메모리 로딩하여 사용가능한 문법
 * 
 * 
 * */


/*static*/class Static1{
	
	static class Inner{}//내부클래스는 스태틱 선언 가능 거의 사용 x
	
	static int a = 0;
	int b = 0; // non-static
	
	static void prn1() {
		//static 메소드에는 non-static 필드는 사용불가
		//non-static 필드는 반드시 객체를 생성을 해야지 사용가능
		//System.out.println(a+b);
		System.out.println(a);
	}
	
	//non=static method
	void prn2() {
		System.out.println(a+b);
	}
}

public class StaticEx1 {
	public static void main(String[] args) {
		Static1 st1 =new Static1();
		//st1.a = 10;
		Static1.a=10;
		st1.b =20;
		Static1.prn1();
		//st1.prn1();
		st1.prn2();
		//static 필드 및 메소드 객체 생성 없이 사용하라는 기능
		//결국은 static 필드 및 메소드는 객체 생성없이 특정한 필드및 메소드만 동적으로 사용할목적이다.
		double d = 3.12345678;
		//Math mt = new Math();
		long c= Math.round(d);
		System.out.println(c);
		System.out.println(Math.PI);
		String str1 = "10";
		String str2 = "20";
		System.out.println(str1+str2);
		System.out.println(Integer.parseInt(str1)+Integer.parseInt(str2));
		
	}
}

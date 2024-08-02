package ch06;

class Car2{
	//문제 : new 연산자로 객체를 만들면 필드가 메소드보다 먼저 만들어진다
	
	void stop() {
		velocity =0;
	}
	int velocity;
	
}
public class CarEx2 {
	public static void main(String[] args) {
		int a =10;
		int b =a; //기본형 타입 : call by value
		a= 20;
		System.out.println(a+":"+b);
		
		Car2 c1= new Car2();
		Car2 c2= new Car2();
		System.out.println(c1);
		System.out.println(c2);
		c1 = c2; // 참조형 : call by reference
		System.out.println(c1);
		System.out.println(c2);
		System.out.println("------------------------------- ");
		for (int i = 0; i < 10; i++) {
			Car2 c3  =new Car2();
			System.out.println(c3);
		}
		//객체를 사용하는 이유는 필드와 메소드 사용
		String str = new String("asdadads");
		System.out.println(str.toUpperCase());
		System.out.println(str.length());
		System.out.println(str.replace('a', 'x'));
		//객체를 생성없이 클래스 명으로 메소드 및 필드
		//32 를 2진수
		System.out.println(Integer.toBinaryString(32                                                                                                                                                                                                ));
	}
}

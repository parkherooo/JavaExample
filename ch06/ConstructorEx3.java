package ch06;

import java.awt.Frame;

class Super3 extends Object{ //extend : 종속관계
	Super3(){
		/*진짜 생략 (반드시 생성자의 첫번째 라인->
		 * 내 객체가 만들어지기 전에 부모 클래스 객체가 먼저 만들어지져야함) */
		super();
		System.out.println("Super3 생성자");
	}
}
class Sub3 extends Super3{ //3대클래스. 1대 0bject 2대 Super3
	Sub3() {
		super();
		System.out.println("Sub3 생성자");
	}
	
}
public class ConstructorEx3 {
	public static void main(String[] args) {
		Super3 s1 = new Super3();
		Sub3 s3 =new Sub3(); //종속관계로 1대,2대3대 출력
		Frame f = new Frame();
		
	}
}

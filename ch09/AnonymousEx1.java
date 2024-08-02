package ch09;

//익명 클래스는 추상클래스와 인터페이스 사용하기 위한 목적으로 제공

abstract class MyAbst1{
	abstract void prn1();
	
}

interface MyInter1{
	void prn2();
}

//일반적인 구현 형태
class A extends MyAbst1 {
	@Override
	void prn1() {
		System.out.println("prn1 호출");
	}
}

class B implements MyInter1{
	@Override
	public void prn2() {
		System.out.println("prn2 호출");
	}
}



public class AnonymousEx1 {

	public static void main(String[] args) {
		A a = new A();
		a.prn1();
		B b = new B();
		b.prn2();
		/////////////////////////////////////
		new MyAbst1()/*타입선언*/ /*구현시작*/{
			
			@Override
			void prn1() {
				System.out.println("익명 크래스 구현 호출 1");
			}
		}.prn1();
		new MyInter1() {
			
			@Override
			public void prn2() {
				System.out.println("익명 클래스 구현 호출 2");
			}
		}.prn2();
	}
}

package ch09;

/*			중첩(내부)클래스
 * 1. 클래스 안에 선언(활용 100%)
 * 2. 클래스 안에 선언이지만 static 클래스 선언(활용 1%)
 * 3. 메소드 안에 클래스 선언(활용 10%)
 * 4. 메소드 안에 선언을 하고 동시에 익명클래스(활용 100%)
 * PS : 메소드 안에 메소드 선언은 불가 <-JPS
 * */

interface MyInter{
	void prn();
	
}

class Outer1{
	/*1*/ class Inner1{}
	
	/*2*/ static class Inner2{}
	
	void method() {
		
		/*3*/ class Inner3{}
		
		/*4*/ new MyInter() {
			
			@Override
			public void prn() {
			}
		};  // 중괄호 뒤 세미클론은 익명클래스구나 생각. 
	}
}

public class InnerEx1 {
	public static void main(String[] args) {
		
	}
}

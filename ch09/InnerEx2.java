package ch09;

class Outer2{
	int a = 22;//외부 클래스 필드
	void prn1(){
		System.out.println("a : "+a);
		//내부클래스 메소드 및 필드 직접호출 불가능
		//prn();
		//System.out.println("b : "+ b);
		//일반적으로 내부 클래스는 선언된 외부 클래스 내에서 사용
		//이우는 내부 클래스는 외부 클래스와 밀접한 관계로 만들어 짐.
	}
	
	//외부클래스 입장에서는 내부클래스를 메소드이 형태 인식
	//메소드는 없는 클래스의 많은 기능이 있다 상속 ,객체 
	class Inner2{
		int b = 23;
		void prn2() {
			prn1();//외부 클래스 메소드 직접 호출가능
			System.out.println("a+b : "+(a+b)); //외부클래스 필드 직접 사용가능
		}
	}//--Inner2
}//--Outer2

public class InnerEx2 {
	public static void main(String[] args) {
		//제 3의 클래스에서 내부 클래스 사용방법
		//사용되는 경우는 거의 없음
		Outer2 out = new Outer2();
		Outer2.Inner2 in = out.new Inner2();
		in.b = 45;
		in.prn2();
	}
}

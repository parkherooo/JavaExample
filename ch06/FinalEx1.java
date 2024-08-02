package ch06;

import java.awt.Label;

/*final : 클래스,필드,메소드
 * 1. 클래스 : Super 클래스이 역할을 할 수 없는 클래스. 즉 Sub 클래스가 없는 클래스
 * (String, Math,System)
 * 2. 변수 : 상수선언(필드, 매개변수, 지역변수 <- 메소드 안에 선언된 변수)
 * 3. 메소드 : 오버라이딩 불가 메소드
 */
 
final class Final1{}

//class Final2 extends Final1{}

class Final3{
	//상수 : 한번 정해진 값이 변경이 불가능한 변수
	static final int KIA =1;
	//상수는 반드시 초기와 되어야 하는지? YES
	int a;
	//final static int LOTTE;
	final static int LOTTE =2;
	//상수는 변수명 자체가 의미를 가진다.
	Label label1 = new Label("하하",1);
	Label label2 = new Label("하하",Label.CENTER);
	void prn(final int b/*매개변수 상수*/) {
		//b= 10;
		//지역변수는 반드시 초기화가 필요하고 선언되어 있지 않으면 사용하는 시점에 컴파일오류
		int c =0;
		System.out.println(c);
		final int d =10;
		//d=20;
	}
}
class Final4{
	void prn1() {}
	final void prn2() {}
}
class Final5 extends Final4{
	void prn1() {}
	//void prn2() {} //Final4에서 final 로 선언되어서 오버라이딩 불가
}


public class FinalEx1 {
	public static void main(String[] args) {
		
	}
}

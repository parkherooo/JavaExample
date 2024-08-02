package ch07;

import java.awt.Component;

//추상클래스 : 추상적으로 존재하는 클래스이고 타입으로만 사용가능
abstract class Abstract1{
	//추상메소드 : 일반적으로 추상클래스는 추상메소드를 가지고있음
	abstract void prn(); //메소드 선언부
}

class Normal1 extends Abstract1{
	
	@Override
	void prn() {
	}
}


//추상클래스느 반드시 추상메소드를 가질필요는 없다.
class MComponent extends Component{}

public class AbstractEx1 {
	public static void main(String[] args) {
		Abstract1 at; // 참조형 타입으로만 존재
		// = new Abstract1();
		at = new Normal1();
	}
}

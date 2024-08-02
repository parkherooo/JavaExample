package ch07;

import java.io.IOException;

class Super2{
	
	void prn1() {}
	
	//private 으로 선언된 메소드는 오버라이딩 불가.
	protected void prn2() {}
	
	void prn3() throws IOException{}
}

class Sub2 extends Super2{
	//@Override  괄호 사이에 int a 가 들어가서 Ovrride가 성립안됨
	void prn1(int a) {}
	
	@Override  //부모클래스의 범위보다 자식클래스의 범위가 작으면 안됨. ex) 부모 : public , 자식 : protected 불가
	public void prn2() {}
	
	@Override //같은 예외 객체가 throws 해야함.
	void prn3() throws IOException{}
}



public class InheritanceEx2 {
	private void name() {
		
	}
}

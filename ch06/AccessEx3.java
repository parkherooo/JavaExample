package ch06;

import java.awt.Frame;

//jdk에서 지원되는 클래스의 메소드 중에 protected 사용하는방법 
class MyFrame extends Frame{
	public MyFrame() {
		setSize(200,200);
		setLocation(100,200);
		setVisible(true);
		
	}
	public void prn() {
		//유일한 방법
		System.out.println(paramString());
	}
}

public class AccessEx3 {
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
		mf.prn();
	}
}

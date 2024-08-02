package ch08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame2 extends MFrame {
	
Button btn;
	
	public MyFrame2() {
		btn = new Button("Button2");
		setBackground(MColor.rColor());
		add(btn,BorderLayout.SOUTH);
		//익명 클래스 문법으로 인터페이스 사용 
		//매개변수 ActionListener 타입
		//선언과 동시에 객체를 생성  <- 익명클래스
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(MColor.rColor());
			}
		});
	}

	public static void main(String[] args) {
		new MyFrame2();
	}

}

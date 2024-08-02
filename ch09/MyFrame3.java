package ch09;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame3 extends MFrame {
	
	Button btn1, btn2;
	
	public MyFrame3() {
		setTitle("MyFrame3");
		Panel p = new Panel();
		p.add(btn1 = new Button("Btn1"));
		p.add(btn2 = new Button("Btn2"));
		//익명 클래스로 배경색 변경기능과 종료기능 각각 구현
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(MColor.rColor());
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(p, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		new MyFrame3();
	}
}





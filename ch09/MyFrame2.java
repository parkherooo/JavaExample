package ch09;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame2 extends MFrame {

	Button btn1, btn2;

	public MyFrame2() {
		Panel p = new Panel();
		p.add(btn1 = new Button("Btn1"));
		p.add(btn2 = new Button("Btn2"));
		MyAction2 ma = new MyAction2();
		btn1.addActionListener(ma);
		btn2.addActionListener(ma);
		add(p, BorderLayout.SOUTH);
	}

	// 내부 클래스 구현
	class MyAction2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();

			if (obj == btn1) {
				setBackground(MColor.rColor());
			} else if (obj == btn2) {
				System.exit(0);
			}
		}
	}// --MyAction2

	public static void main(String[] args) {
		new MyFrame2();
	}
}

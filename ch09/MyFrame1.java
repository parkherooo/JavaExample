package ch09;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//버튼을 클릭하면 종료되는 기능을 내부클래스와 익명 클래스를 사용하지 않는 방법

class MYAction implements ActionListener{
	Frame f;
	public MYAction(MyFrame1 f) {
		this.f =f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.exit(0); //종료기능
		f.setBackground(MColor.rColor());
	}
}

public class MyFrame1 extends MFrame {
	Button btn;
	
	public MyFrame1() {
		btn = new Button("button1");
		add(btn, BorderLayout.NORTH);
		MYAction ma = new MYAction(this);
		btn.addActionListener(ma);
	}
	
	public static void main(String[] args) {
		new MyFrame1();
	}

}

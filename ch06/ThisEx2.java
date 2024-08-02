package ch06;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ThisFrame extends MFrame3 implements ActionListener/*인터페이스*/{
	Button btn;
	public ThisFrame() {
		btn = new Button("my Button");
		add(btn,BorderLayout.SOUTH);
		//버튼을 클릭하면 actionPerformed 호출
		//매개변수가 ActionListener 타입객체
		btn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		setBackground(MColor.rColor());
	}
}

public class ThisEx2 {
	public static void main(String[] args) {
		new ThisFrame();
	}
}

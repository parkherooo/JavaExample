package ch06;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MFrame2 extends Frame {
	public MFrame2() {
		setSize(300, 300);
		setBackground(Color.BLUE);
		setResizable(false);
		setVisible(true);
		// 종료기능
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		validate(); //안그려져있을 때 한번 더 그려줌
	}

	public MFrame2(int w, int h, Color c, boolean resize) {
		setSize(w, h);
		setBackground(c);
		setResizable(resize);
		setVisible(true);
		// 종료기능
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
}

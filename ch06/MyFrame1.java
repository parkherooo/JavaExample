package ch06;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MyFrame1 {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setSize(300, 300);
		f.setBackground(randomColor());
		f.setVisible(true);
		Button btn = new Button("Click");
		f.add(btn, "South");
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setBackground(randomColor());
				;
			}
		});
	}

	public static Color randomColor() {
		Random rd = new Random();
		int r = rd.nextInt(256);// 0~255 랜덤정수
		int g = rd.nextInt(256);// 0~255 랜덤정수
		int b = rd.nextInt(256);// 0~255 랜덤정수
		return new Color(r, g, b);
	}
}

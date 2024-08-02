package ch06;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyFrame3 extends MFrame3 {
	
	public MyFrame3() {
		super(Color.orange);
		Button btn = new Button("Click");
		add(btn,"South");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(randomColor());
			}
		});
	}

	public static void main(String[] args) {
		new MyFrame3();
	}

}

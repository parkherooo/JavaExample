package ch06;

import java.awt.Color;
import java.awt.TextArea;
import java.awt.TextField;
import java.util.Random;

public class YouFrame3 extends MFrame3 {
	
	public YouFrame3 () {
		super(250,250);
		TextArea ta;
		TextField tf;
		add(ta = new TextArea());
		add(tf =new TextField(),"South");
		Color c[]=MColor.rColor2();
		ta.setBackground(c[0]);
		ta.setForeground(c[1]);
		tf.setBackground(c[0]);
		tf.setForeground(c[1]);
		validate();
		
	}
	
	public static void main(String[] args) {
		new YouFrame3();
		Random r = new Random();
		/*
		 * for (int i = 0; i < 1000; i++) { MFrame3 m = new MFrame3();
		 * m.setBackground(m.randomColor());
		 * m.setBounds(r.nextInt(1000),r.nextInt(700),200,200); m.validate(); }
		 */
	}
}

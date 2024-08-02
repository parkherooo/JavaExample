package ch06;
//this 를 사용하여 부모클래스에 생성자 효율적 선언
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MFrame3 extends Frame {
	
	public MFrame3() {
		this(300,300,new Color(220,220,220),false);
	}
	
	public MFrame3(int w, int h) {
		this(w,h,new Color(220,220,220),false);
	}
	
	public MFrame3(Color c) {
		this(300,300,c,false);
	}
	
	public MFrame3(int w,int h,Color c, boolean resize) {
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
		validate(); //안그려져있을 때 한번 더 그려줌
	}
	public static Color randomColor() {
		Random rd = new Random();
		int r = rd.nextInt(256);// 0~255 랜덤정수
		int g = rd.nextInt(256);// 0~255 랜덤정수
		int b = rd.nextInt(256);// 0~255 랜덤정수
		return new Color(r, g, b);
	}
}

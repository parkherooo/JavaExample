package awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.util.Random;

public class BorderLayoutEx1 extends MFrame2 {
	
	String str[] = {"ù��°","�ι�°","����°","�׹�°","�ټ���°"};
	Button btn[] = new Button[5];
	
	public BorderLayoutEx1() {
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button(str[i]);
			Color c[] = MColor.rColor2();
			btn[i].setBackground(c[0]);
			btn[i].setForeground(c[1]);
		}
		add(btn[0],"North");
		add(btn[1],BorderLayout.EAST);
		add(BorderLayout.SOUTH,btn[2]);
		add("West",btn[3]);
		add(btn[4]); //�⺻���� �������� ������ �⺻�� center
	}

	public static void main(String[] args) {
		Random r = new Random();
		for (int i = 0; i < 1000; i++) {
			BorderLayoutEx1 bl = new BorderLayoutEx1();
			int x = r.nextInt(2000);
			int y = r.nextInt(1000);
			int len = r.nextInt(200)+100;//100~300
			bl.setBounds(x, y, len, len);
			bl.validate();
		}
		
		
	}

}

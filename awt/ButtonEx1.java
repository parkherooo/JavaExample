package awt;

import java.awt.Button;
import java.awt.Color;

public class ButtonEx1 extends MFrame {
	
	Button btn[] = new Button[4];
	String label[] = {"�߰�", "����", "��ü����" , "����"};
	
	public ButtonEx1() {
		super(250,250);
		setTitle("Button ����");
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button(label[i]);
			Color c[]= MColor.rColor2();
			btn[i].setBackground(c[0]);
			btn[i].setBackground(c[1]);
			add(btn[i]);
		}
		validate();
	}
	public static void main(String[] args) {
		new ButtonEx1();
	}

}

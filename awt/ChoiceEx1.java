package awt;

import java.awt.Choice;
import java.awt.Color;

public class ChoiceEx1 extends MFrame {
	
	Choice ch;
	String city[] = {"���ø� �����ϼ���.","������","�� ��", "�Ͽ���","�� ��","�� ��","�� ��"};
	
	public ChoiceEx1() {
		super(300,300,new Color(100,200,100));
		setTitle("Choice ����1");
		ch = new Choice();
		for (int i = 0; i < city.length; i++) {
			ch.add(city[i]);
		}
		add(ch);
		validate();
	}
	
	public static void main(String[] args) {
		new ChoiceEx1();
	}
}

package awt;

import java.awt.Color;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TextEx1 extends MFrame implements ActionListener {
	
	TextField tf1, tf2;
	TextArea ta;
	
	public TextEx1() {
		super(250,300);
		add(new Label("����"));
		add(tf1 = new TextField("ȫ�浿",20));
		add(new Label("��ȣ"));
		
		add(tf2 = new TextField("",20));
		tf2.setEchoChar('@');
		tf2.addActionListener(this);
		add(ta = new TextArea(10,30));
		//ta.setEditable(false);
		//ta.setEnabled(false);
		ta.append("Text ����");
		Color c[] = MColor.rColor2();
		ta.setBackground(c[0]);
		ta.setForeground(c[1]);
		validate();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = tf1.getText()+"/"+tf2.getText()+"\n";
		ta.append(str);
		tf1.setText("");
		tf2.setText("");
		tf1.requestFocus();
	}
	public static void main(String[] args) {
		new TextEx1();
	}

}

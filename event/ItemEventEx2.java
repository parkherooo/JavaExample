package event;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class ItemEventEx2 extends MFrame {
	
	Label label;
	Checkbox cb1, cb2, cb3;
	
	public ItemEventEx2() {
		super(300, 200);
		setLayout(new FlowLayout());
		add(cb1=new Checkbox("����"));
		add(cb2=new Checkbox("�ٳ���"));
		add(cb3=new Checkbox("���"));
		add(label = new Label("���� ���� :                    "));
		MyItem my = new MyItem();
		cb1.addItemListener(my);
		cb2.addItemListener(my);
		cb3.addItemListener(my);
		validate();
	}
	class MyItem implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			Checkbox cb = (Checkbox)e.getSource();
			String str = cb.getLabel() +" : "+cb.getState();
			label.setText(str);
			setTitle(str);
		}
	}

	public static void main(String[] args) {
		new ItemEventEx2();
	}
}
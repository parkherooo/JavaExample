package event;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemEventEx3 extends MFrame {
	
	Label label;
	Checkbox cb1, cb2, cb3;
	
	public ItemEventEx3() {
		super(300, 200);
		setLayout(new FlowLayout());
		add(cb1=new Checkbox("����"));
		add(cb2=new Checkbox("�ٳ���"));
		add(cb3=new Checkbox("���"));
		add(label = new Label("���� ���� :                    "));
		cb1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Checkbox cb = (Checkbox)e.getSource();
				String str = cb.getLabel() +" : "+cb.getState();
				label.setText(str);
				setTitle(str);
			}
		});
		cb2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Checkbox cb = (Checkbox)e.getSource();
				String str = cb.getLabel() +" : "+cb.getState();
				label.setText(str);
				setTitle(str);
			}
		});
		cb3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Checkbox cb = (Checkbox)e.getSource();
				String str = cb.getLabel() +" : "+cb.getState();
				label.setText(str);
				setTitle(str);
			}
		});
		validate();
	}

	public static void main(String[] args) {
		new ItemEventEx3();
	}
}
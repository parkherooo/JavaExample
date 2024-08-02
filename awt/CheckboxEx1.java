package awt;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckboxEx1 extends MFrame implements ItemListener{
	
	Checkbox cb[] = new Checkbox[3];
	Checkbox rb[] = new Checkbox[3];
	CheckboxGroup grp;
	String label1[] = {"����1", "����2" ,"����3"};
	String label2[] = {"����1", "����2" ,"����3"};
	
	public CheckboxEx1() {
		super(420,120);
		setTitle("Checkbox ����");
		grp = new CheckboxGroup();
		
		for (int i = 0; i < cb.length; i++) {
			cb[i] = new Checkbox(label1[i],false);
			cb[i].addItemListener(this);
			add(cb[i]);
		}
		for (int i = 0; i < rb.length; i++) {
			rb[i] = new Checkbox(label2[i],grp,false);
			rb[i].addItemListener(this);
			add(rb[i]);
		}
		setResizable(true);
		validate();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		//�̺�Ʈ�� ����Ų Checkbox ����
		Checkbox cb = (Checkbox)e.getSource();
		String str = cb.getLabel()+ " :" + cb.getState();
		setTitle(str);
	}
	
	public static void main(String[] args) {
		new CheckboxEx1();
	}

}

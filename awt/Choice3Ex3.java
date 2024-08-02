package awt;

import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;

public class Choice3Ex3 extends MFrame  implements ItemListener{
	
	Choice name, star;
	String ms[] = {"�� ��","�� ��","�̹�ȣ","�����","����","������"};
	String fs[] = {"��ƶ�","�̿���","���ϴ�","��ä��","�� ��","�迬��"};
	
	public Choice3Ex3() {
		setTitle("Choice ���� 3");
		name = new Choice();
		star = new Choice();
		name.add("���ڿ�����");
		name.add("���ڿ�����");
		/*
		 * for (int i = 0; i < fs.length; i++) { star.add(ms[i]); }
		 */
		inputItem(star, ms);
		name.addItemListener(this);
		add(name);
		add(star);

	}
	public  void inputItem(Choice ch, String item[]) {
		ch.removeAll();                                                                                                                                                                                                                                                                                                                                            
		for (int i = 0; i < item.length; i++) {
			ch.add(item[i]);
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(name.getSelectedItem().equals("���ڿ�����")) {
			inputItem(star, ms);
		} else if(name.getSelectedItem().equals("���ڿ�����")) {
			inputItem(star, fs);
		}
	}
	
	
	public static void main(String[] args) {
		new Choice3Ex3();
	}

}

package awt;

import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;

public class Choice3Ex3 extends MFrame  implements ItemListener{
	
	Choice name, star;
	String ms[] = {"현 빈","원 빈","이민호","김수현","김우빈","이종석"};
	String fs[] = {"고아라","이연희","이하늬","문채원","수 지","김연아"};
	
	public Choice3Ex3() {
		setTitle("Choice 예제 3");
		name = new Choice();
		star = new Choice();
		name.add("남자연예인");
		name.add("여자연예인");
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
		if(name.getSelectedItem().equals("남자연예인")) {
			inputItem(star, ms);
		} else if(name.getSelectedItem().equals("여자연예인")) {
			inputItem(star, fs);
		}
	}
	
	
	public static void main(String[] args) {
		new Choice3Ex3();
	}

}

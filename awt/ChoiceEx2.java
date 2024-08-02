package awt;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceEx2 extends MFrame implements ItemListener /*Choice 선택*/{
	
	Choice air, city;
	String sair[] = {"대한항공","아시아나","에어부산","진에어"};
	String scity[] = {"서 울","대 전","대 구","부 산","제주도"};
	
	public ChoiceEx2() {
		super(300,300,new Color(150,200,150));
		setTitle("Choice 예제2");
		air = new Choice();
		for (int i = 0; i < sair.length; i++) {
			air.add(sair[i]);
		}
		
		city = new Choice();
		for (int i = 0; i < sair.length; i++) {
			city.add(scity[i]);
		}
		//air 와 city의 item을 변경하면 itemStatedChaged 호출
		air.addItemListener(this);
		city.addItemListener(this);
		add(air);
		add(city);
		add(new Label("항공사와 도시를 선택하세요"));
		validate();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		repaint(); //결과적으로 paint 호출
	}
	
	@Override
	//생성자 호출 후에 자동으로 호출되는 메소드
	public void paint(Graphics g /*g 는 붓역할*/) {
		super.paint(g);
		if(air==null||city==null)
			return;
		g.setColor(Color.blue);
		String str ="항공사 선택 : "+air.getSelectedItem();
		g.drawString(str, 30,120);
		
		g.setColor(Color.red);
		str ="도시 선택 : "+city.getSelectedItem();
		g.drawString(str, 30,150);
		
	}

	public static void main(String[] args) {
		new ChoiceEx2();
	}
}

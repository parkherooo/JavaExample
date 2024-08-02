package event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*2. ��ư�� Ŭ���ϸ� ActionEvent ��ü�� ����
	  �̺�Ʈ �ҽ��� ActionEvent ��ü�� �����ϱ����� �����ʸ� ����. XxxListener*/
public class EventEx1 extends MFrame implements ActionListener /* �̺�Ʈ ������ */{
	
	Button btn;
	public EventEx1() {
		//1. �̺�Ʈ �ҽ� ����
		add(btn = new Button("��ư"),BorderLayout.SOUTH);
		//4. �̺�Ʈ �ҽ��� �̺�Ʈ �ڵ鷯 ����(addXxxListener)
		btn.addActionListener(this);
		}
	
	//3. �̺�Ʈ �������� �޼ҵ�(�̺�Ʈ�ڵ鷯)�� �����Ѵ�.
	@Override
	public void actionPerformed(ActionEvent e) {
		setBackground(MColor.rColor());
	}
	
	public static void main(String[] args) {
		new EventEx1();
	}
}
package awt;

import java.awt.Label;

public class LabelEx1 extends MFrame {
	Label label[] = new Label[4]; //Label ��ü�� ��������� �ƴ�
	int pos[] = {Label.LEFT, Label.CENTER, Label.RIGHT, Label.LEFT};
	public LabelEx1() {
		super(200,200);
		String str = "������ �ູ�� ������";
		for (int i = 0; i < label.length; i++) {
			label[i] = new Label(str,pos[i]);
			label[i].setBackground(MColor.rColor());
			//������Ʈ �����ϰ� �����ϰ� �����̳ʿ� ����
			add(label[i]);
		}
		setResizable(true);
		validate();
	}
	public static void main(String[] args) {
		new LabelEx1();
	}

}

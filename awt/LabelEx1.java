package awt;

import java.awt.Label;

public class LabelEx1 extends MFrame {
	Label label[] = new Label[4]; //Label 객체가 만들어진게 아님
	int pos[] = {Label.LEFT, Label.CENTER, Label.RIGHT, Label.LEFT};
	public LabelEx1() {
		super(200,200);
		String str = "오늘은 행복한 월요일";
		for (int i = 0; i < label.length; i++) {
			label[i] = new Label(str,pos[i]);
			label[i].setBackground(MColor.rColor());
			//컴포넌트 생성하고 세팅하고 컨테이너에 부착
			add(label[i]);
		}
		setResizable(true);
		validate();
	}
	public static void main(String[] args) {
		new LabelEx1();
	}

}

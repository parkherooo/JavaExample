package graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class ImageViewsEx1 extends MFrame {
	
	Image img;
	
	public ImageViewsEx1() {
		super(550,400);
		img = Toolkit.getDefaultToolkit().getImage("graphics/aaa.jpg");
	}
	//�����̳� ��ü�� �����ǰ� �ʿ��� ���ҽ�(������Ʈ�̹���)�׸��� �޼ҵ� (�ݺ�ȣ��)
	@Override //�׻� repaint() ȣ�� -> paint ȣ��
	public void paint(Graphics g) {
		//System.out.println("paint");
		g.drawImage(img, 0, 0, this);
	}
	
	public static void main(String[] args) {
		new ImageViewsEx1();
	}

}

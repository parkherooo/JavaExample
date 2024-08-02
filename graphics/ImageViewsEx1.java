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
	//컨테이너 객체가 생성되고 필요한 리소스(컴포넌트이미지)그리는 메소드 (반복호출)
	@Override //항상 repaint() 호출 -> paint 호출
	public void paint(Graphics g) {
		//System.out.println("paint");
		g.drawImage(img, 0, 0, this);
	}
	
	public static void main(String[] args) {
		new ImageViewsEx1();
	}

}

package ch12;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class RunnableFrameEx3_1 extends MFrame implements Runnable {
	
	Color c;
	int x,  y;
	Random r =new Random();
	
	public RunnableFrameEx3_1(int x1, int y1) {
		super(200,200);
		setLocation(x1, y1);
		c= MColor.rColor();
	}

	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			x = r.nextInt(200);
			y = r.nextInt(200);
			try {
					Thread.sleep(500);//0.5
					repaint(); //update 
			} catch (Exception e) {
			}
		}
	}
	
	//repaint -> update -> paint
	@Override
	public void update(Graphics g) {
		g.clearRect(x,y,10,10);
		paint(g);
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(c);
		g.fillOval(x, y, 10, 10);
	}
	
	public static void main(String[] args) {
		RunnableFrameEx3_1 ra[] = new RunnableFrameEx3_1[9];
		for (int i = 0; i < ra.length; i++) {
			int x1 = 200+ (200*(Math.floorMod(i, 3))); //나눗셈 나머지
			int y1= 200+(200*(Math.floorDiv(i,3)));//나눗셈 몫
			ra[i] = new RunnableFrameEx3_1(x1, y1);
			new Thread(ra[i]).start();
		}
	}

}

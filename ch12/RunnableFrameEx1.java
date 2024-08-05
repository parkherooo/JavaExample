package ch12;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class RunnableFrameEx1 extends MFrame implements Runnable {
	
	Color c;
	int x,  y;
	Random r =new Random();
	public RunnableFrameEx1(Color c) {
		super(300,300);
		this.c = c;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				x = r.nextInt(300);
				y = r.nextInt(300);
				Thread.sleep(500);//0.5
				repaint(); //update 
			}
		} catch (Exception e) {
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
		RunnableFrameEx1 f1 = new RunnableFrameEx1(Color.pink);
		RunnableFrameEx1 f2 = new RunnableFrameEx1(Color.green);
		new Thread(f1).start();
		new Thread(f2).start();
	}

}

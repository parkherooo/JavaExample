package ch12;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class RunnableFrameEx3 extends MFrame implements Runnable {
	
	Color c;
	int x,  y;
	Random r =new Random();
	
	public RunnableFrameEx3(int x1, int y1) {
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
		RunnableFrameEx3 f1 = new RunnableFrameEx3(200,200);
		RunnableFrameEx3 f2 = new RunnableFrameEx3(400,200);
		RunnableFrameEx3 f3 = new RunnableFrameEx3(600,200);
		RunnableFrameEx3 f4 = new RunnableFrameEx3(200,400);
		RunnableFrameEx3 f5 = new RunnableFrameEx3(400,400);
		RunnableFrameEx3 f6 = new RunnableFrameEx3(600,400);
		RunnableFrameEx3 f7 = new RunnableFrameEx3(200,600);
		RunnableFrameEx3 f8 = new RunnableFrameEx3(400,600);
		RunnableFrameEx3 f9 = new RunnableFrameEx3(600,600);
		new Thread(f1).start();
		new Thread(f2).start();
		new Thread(f3).start();
		new Thread(f4).start();
		new Thread(f5).start();
		new Thread(f6).start();
		new Thread(f7).start();
		new Thread(f8).start();
		new Thread(f9).start();
	}

}

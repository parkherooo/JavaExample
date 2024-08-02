package graphics;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Random;

public class ImageViewsEx2_1 extends MFrame implements ActionListener {
	
	Image img[] = new Image[3];
	Button btn[] = new Button[4];
	String label[] = {"첫번째","두번째","세번째","랜덤"}; 
	Random r = new Random();
	int idx = 0;
	public ImageViewsEx2_1() {
		super(550,300);
		Panel p = new Panel();
		p.setLayout(new GridLayout(4,1));
		
		for (int i = 0; i < btn.length; i++) {
			p.add(btn[i] = new Button(label[i]));
			btn[i].addActionListener(this);
		}
		for (int i = 0; i < img.length; i++) {
			img[i]= Toolkit.getDefaultToolkit().getImage("graphics/aaa"+i+".PNG");
		}
		add(p, BorderLayout.EAST);
		validate();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn[0]) idx=0;
		else if (obj==btn[1]) idx=1;
		else if (obj==btn[2]) idx=2;
		else if (obj==btn[3]) idx=r.nextInt(3);
		repaint();
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(img==null)
			return;
		setTitle("graphics/aaa"+idx+".PNG");
		g.drawImage(img[idx], 0, 0, this);
	}
	public static void main(String[] args) {
		new ImageViewsEx2_1();
	}
}

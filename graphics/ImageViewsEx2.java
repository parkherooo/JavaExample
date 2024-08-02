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
import java.util.Random;

public class ImageViewsEx2 extends MFrame {
	
	Image img;
	Button btn[] = new Button[4];
	String label[] = {"첫번째","두번째","세번째","랜덤"}; 
	public ImageViewsEx2() {
		super(550,300);
		Panel p = new Panel();
		p.setLayout(new GridLayout(4,1));
		img = Toolkit.getDefaultToolkit().getImage("graphics/aaa0.PNG");
		for (int i = 0; i < btn.length; i++) {	
			p.add(btn[i] = new Button(label[i]));
		}
		add(p,BorderLayout.EAST);
		
		btn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint(); 
				img = Toolkit.getDefaultToolkit().getImage("graphics/aaa0.PNG");
				setTitle("graphics/aaa0.PNG");
			}
		});
		
		btn[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				img = Toolkit.getDefaultToolkit().getImage("graphics/aaa1.PNG");
				setTitle("graphics/aaa1.PNG");
			}
		});
		
		btn[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				img = Toolkit.getDefaultToolkit().getImage("graphics/aaa2.PNG");
				setTitle("graphics/aaa2.PNG");
			}
		});
		
		btn[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				Random rd = new Random();
				int a =rd.nextInt(3);
				String s[]= {"graphics/aaa0.PNG","graphics/aaa1.PNG","graphics/aaa2.PNG"};
				img = Toolkit.getDefaultToolkit().getImage(s[a]);
				setTitle(s[a]);
			}
		});
		validate();
	}
	@Override //항상 repaint() 호출 -> paint 호출
	public void paint(Graphics g) {
		//System.out.println("paint");
		g.drawImage(img, 0, 0, this);
	}
	public static void main(String[] args) {
		new ImageViewsEx2();
	}
}

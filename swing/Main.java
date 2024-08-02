package swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame{
	
	public Main() {
		setSize(300,300);
		setLayout(new FlowLayout());
		JButton btn = new JButton("버튼");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btn.setBackground(Color.orange);
			}
		});
		btn.setForeground(Color.RED);
		JLabel label = new JLabel("라벨");
		label.setForeground(Color.GREEN);
		add(btn);
		add(label);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Main();
	}
}

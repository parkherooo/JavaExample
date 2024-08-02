package event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//TextField에 Key이벤트
public class KeyEventEx1 extends MFrame implements ActionListener, KeyListener{
	
	TextField tf;
	TextArea ta;
	Button btn;
	
	public KeyEventEx1() {
		super(300,500);
		add(tf = new TextField(),BorderLayout.SOUTH);
		add(ta = new TextArea());
		ta.setEditable(false);
		btn = new Button("REMOVE");
		btn.addActionListener(this);
		tf.addKeyListener(this);
		add(btn,BorderLayout.NORTH);
		validate();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		ta.append("##keyTyped : " + tf.getText()+"\n");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		ta.append("##keyPreassed : " + tf.getText()+"\n");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		ta.append("##keyReleased : " + tf.getText()+"\n");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ta.setText("");
		tf.setText("");
		tf.requestFocus();
	}
	
	public static void main(String[] args) {
		new KeyEventEx1();
		
	}
}
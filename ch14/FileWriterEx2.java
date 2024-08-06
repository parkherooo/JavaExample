package ch14;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import com.teamdev.jxbrowser.deps.org.checkerframework.checker.units.qual.Time;

public class FileWriterEx2 extends MFrame 
implements ActionListener {

	TextArea ta;
	TextField tf;
	Button save;
	
	public FileWriterEx2() {
		super(300, 400);
		setTitle("FileWriterEx1");
		add(ta=new TextArea());
		Panel p = new Panel();
		p.add(tf = new TextField(25));
		p.add(save = new Button("SAVE"));
		ta.setEditable(false);
		tf.addActionListener(this);
		save.addActionListener(this);
		add(p,BorderLayout.SOUTH);
		validate();                                                                                                                                                                                                                                       
	}
	
	@Override //for문 Thread.sleep(1000) -> 1초
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == tf) {
			ta.append(tf.getText()+"\n");
			tf.setText("");
			tf.requestFocus();
		} else if(obj == save) {
			saveFile(ta.getText());
			ta.setText("");
			try {
				for (int i = 5; i > 0; i--) {
					ta.setText("저장하였습니다. -"+i+"초 후에 사라집니다.");
					Thread.sleep(1000);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			ta.setText("");
		}
	}
	public void saveFile(String txt) {
		try {
			long fname = System.currentTimeMillis();
			FileWriter fw = new FileWriter("ch14/"+fname+".txt");
			fw.write(txt);
			fw.flush();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new FileWriterEx2();	
	}
}








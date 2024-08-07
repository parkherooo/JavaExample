package net;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChatClient1 extends JFrame 
implements ActionListener, Runnable{
	
	JButton btn1, btn2;
	JTextField tf1, tf2;
	TextArea ta;
	JPanel p1, p2;
	BufferedReader in;
	PrintWriter out;
	String id;
	public static final int PORT = 8001;
	String host = "127.0.0.1";
	//String host = "113.198.238.123";//����PC
	String swear[] = {"������", "����", "����", "���Ծ�", "��ģ��", "��ģ��"};
	
	public ChatClient1() {
		setSize(350, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MyChat v1.0");
		p1 = new JPanel();
		p1.setBackground(new Color(100,200,100));
		p1.add(new Label("HOST ",Label.CENTER));
		p1.add(tf1 = new JTextField(host, 15));
		p1.add(btn1 = new JButton("Connect"));
		
		p2 = new JPanel();
		p2.setBackground(new Color(100,200,100));
		p2.add(new Label("CHAT ",Label.CENTER));
		p2.add(tf2 = new JTextField("",15));
		p2.add(btn2 = new JButton("SEND"));	
		
		tf1.addActionListener(this);
		tf2.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		add(p1,BorderLayout.NORTH);
		add(ta=new TextArea());
		add(p2,BorderLayout.SOUTH);
		setVisible(true);
		validate();
	}
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==tf1 || obj == btn1) {
			connect(tf1.getText().trim());
			tf1.setEnabled(false);
			btn1.setEnabled(false);
			tf2.requestFocus();
		} else if(obj==tf2 || obj == btn2) {
			String str = tf2.getText().trim();
			if(str.length()==0) return;
			if(filterMgr(str)) {
				new DialogBox(this, "�������Դϴ�.", "���");
				tf2.setText("");
				tf2.requestFocus();
				return;
			}
			if(id==null) { //ó�� �ѹ��� ����
				id =str;
				setTitle(getTitle()+"-["+id+"]");
				ta.setText("Chat Start... \n");
			}
			out.println(str);
			tf2.setText("");
			tf2.requestFocus();
		}
	}//--actionPerformed
	
	@Override //������ ���� �޼����� ������ �����ϴ� ���
	public void run() {
		try {
			while (true) {
				ta.append(in.readLine()+"\n");
				tf2.requestFocus();
			}
		} catch (Exception e) {
			System.err.println("Error in run");
			System.exit(1);
		}
	}//--run
	
	public void connect(String host){
		try {
			Socket sock = new Socket(host,PORT);
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream(),true);
			
			//Server���� ���ʷ� �޴� �޼���
			ta.append(in.readLine()+"\n");
			tf2.requestFocus();
		} catch (Exception e) {
			e.printStackTrace();
		}
		new Thread(this).start();
	}
	
	//return : true <- �弳
	public boolean filterMgr(String msg){
		for (int i = 0; i < swear.length; i++) {
			if(swear[i].equals(msg)||msg.indexOf(swear[i])!=-1) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		new ChatClient1();
	}
}




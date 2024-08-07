package net;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient2 extends JFrame implements ActionListener, Runnable {

	JButton bt1, bt2, bt3, bt4;
	JTextField tf1, tf2, tf3;
	TextArea area;
	List list;
	Socket sock;
	BufferedReader in;
	PrintWriter out;
	String listTitle = "*******��ȭ�ڸ���*******";
	boolean flag = false;
	String swear[] = { "������", "����", "����", "���Ծ�", "��ģ��", "��ģ��" };

	public ChatClient2() {
		setSize(450, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MyChat v2.0");
		JPanel p1 = new JPanel();
		p1.add(new Label("Host", Label.RIGHT));
		p1.add(tf1 = new JTextField("127.0.0.1", 10));
		p1.add(new Label("Port", Label.RIGHT));
		p1.add(tf2 = new JTextField("8002", 5));
		bt1 = new JButton("connect");
		bt1.addActionListener(this);
		p1.add(bt1);
		add(BorderLayout.NORTH, p1);
		// //////////////////////////////////////////////////////////////////////////////////////////
		area = new TextArea("MyChat v2.0");
		area.setBackground(Color.DARK_GRAY);
		area.setForeground(Color.PINK);
		area.setEditable(false);
		add(BorderLayout.CENTER, area);
		// /////////////////////////////////////////////////////////////////////////////////////////
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		list = new List();
		list.add(listTitle);
		p2.add(BorderLayout.CENTER, list);
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(1, 2));
		bt2 = new JButton("Save");
		bt2.addActionListener(this);
		bt3 = new JButton("Message");
		bt3.addActionListener(this);
		p3.add(bt2);
		p3.add(bt3);
		p2.add(BorderLayout.SOUTH, p3);
		add(BorderLayout.EAST, p2);
		// ///////////////////////////////////////////////////////////////////////////////////////////
		JPanel p4 = new JPanel();
		tf3 = new JTextField("", 30);
		tf3.addActionListener(this);
		bt4 = new JButton("send");
		bt4.addActionListener(this);
		p4.add(tf3);
		p4.add(bt4);
		add(BorderLayout.SOUTH, p4);
		setVisible(true);
		validate();
	}

	public void run() {
		try {
			String host = tf1.getText().trim();
			int port = Integer.parseInt(tf2.getText().trim());
			connect(host, port);
			area.append(in.readLine());
			while(true) {
				String line = in.readLine();
				if(line==null)
					break;
				else
					routine(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// --run

	public void routine(String line) {
		
	}// --routine

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==bt1) {
			
		}else if(obj==bt2) {
			
		}else if(obj==bt3) {
			
		}else if(obj==bt4||obj==tf3) {
		
		}
	}// --actionPerformed

	public void connect(String host, int port) {
		try {
			sock = new Socket(host, port);
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream(), true/* auto flush */);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// --connect

	public void sendMessage(String msg) {
		out.println(msg);
	}

	// return : true <- �弳
	public boolean filterMgr(String msg) {
		for (String s : swear) {
			if(msg.contains(s)) {
				return true;
			}
		}
		return false;
	}

	class Message extends Frame implements ActionListener {

		Button send, close;
		TextField name;
		TextArea ta;
		String mode;// to/from
		String id;

		public Message(String mode) {
			setTitle("����������");
			this.mode = mode;
			id = list.getSelectedItem();
			layset("");
			validate();
		}

		public Message(String mode, String id, String msg) {
			setTitle("�����б�");
			this.mode = mode;
			this.id = id;
			layset(msg);
			validate();
		}

		public void layset(String msg) {
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dispose();
				}
			});
			Panel p1 = new Panel();
			p1.add(new Label(mode, Label.CENTER));
			name = new TextField(id, 20);
			p1.add(name);
			add(BorderLayout.NORTH, p1);

			ta = new TextArea("");
			add(BorderLayout.CENTER, ta);
			ta.setText(msg);
			Panel p2 = new Panel();
			if (mode.equals("TO:")) {
				p2.add(send = new Button("send"));
				send.addActionListener(this);
			}
			p2.add(close = new Button("close"));
			close.addActionListener(this);
			add(BorderLayout.SOUTH, p2);

			setBounds(200, 200, 250, 250);
			setVisible(true);
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == send) {
				sendMessage(ChatProtocol2.MESSAGE + ":" + id + ";" + ta.getText());
			}
			setVisible(false);
			dispose();
		}
	}

	public static void main(String[] args) {
		new ChatClient2();
	}
}

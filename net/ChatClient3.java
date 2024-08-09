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
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ChatClient3 extends JFrame 
implements ActionListener, Runnable {

	JButton  listBtn, msgBtn, saveBtn,  sendBtn;
	JTextField sendTf;
	TextArea contentArea;
	List chatList;
	Socket sock;
	BufferedReader in;
	PrintWriter out;
	String title = "MyChat 3.0";
	String listTitle = "*****CHAT LIST*****";
	boolean flag = false;
	String id;
	String label[] = {"MLIST", "MESSAGE","SEND","SAVE"};
	String swear[] = { "������", "����", "����", "���Ծ�", "��ģ��", "��ģ��" };
	MsgAWT3 msgAWT3;

	public ChatClient3(BufferedReader in, PrintWriter out, String id) {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.in = in;
		this.out = out;
		this.id = id; 
		setTitle(title + " - " + id + "�� �ݰ����ϴ�.");
		contentArea = new TextArea();
		contentArea.setBackground(Color.DARK_GRAY);
		contentArea.setForeground(Color.GREEN);
		contentArea.setEditable(false);
		add(BorderLayout.CENTER, contentArea);
		// /////////////////////////////////////////////////////////////////////////////////////////
		Panel p2 = new Panel();
		p2.setLayout(new BorderLayout());
		chatList = new List();
		chatList.add(listTitle);
		p2.add(BorderLayout.CENTER, chatList);
		Panel p3 = new Panel();
		p3.setLayout(new GridLayout(1, 2));
		listBtn = new JButton(label[0]);
		listBtn.addActionListener(this);
		msgBtn = new JButton(label[1]);
		msgBtn.addActionListener(this);
		p3.add(listBtn);
		p3.add(msgBtn);
		p2.add(BorderLayout.SOUTH, p3);
		add(BorderLayout.EAST, p2);
		// ///////////////////////////////////////////////////////////////////////////////////////////
		Panel p4 = new Panel();
		sendTf = new JTextField("", 30);
		sendTf.requestFocus();
		sendTf.addActionListener(this);
		sendBtn = new JButton(label[2]);
		sendBtn.addActionListener(this);
		saveBtn = new JButton(label[3]);
		saveBtn.addActionListener(this);
		p4.add(sendTf);
		p4.add(sendBtn);
		p4.add(saveBtn);
		add(BorderLayout.SOUTH, p4);
		new Thread(this).start();
		setVisible(true);
		validate();
	}
	
	public void run() {
		try {
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
	}//--run
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==saveBtn/*save*/) {
			String content = contentArea.getText();
			//1970��1��1�� ~������� 1/1000�� ������ ���
			long fileName = System.currentTimeMillis();
			try {
				FileWriter fw = new FileWriter("net/"+fileName+".txt");
				fw.write(content);
				fw.close();
				contentArea.setText("");
				new DialogBox(this, "��ȭ������ �����Ͽ����ϴ�", "Save");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else if(obj==listBtn) {
			sendMessage(ChatProtocol3.MSGLIST+
					ChatProtocol3.MODE1+id);
		}else if(obj==msgBtn/*message*/) {
			int i = chatList.getSelectedIndex();
			if(i==-1||i==0) {
				new DialogBox(this, "���̵� �����ϼ���", "�˸�");
			}else {
				new Message("TO");
			}
		}else if(obj==sendBtn ||obj==sendTf) {
			String str = sendTf.getText();
			if(filterMgr(str)) {
				new DialogBox(this, "�Է��Ͻ� ��¥�� �������Դϴ�", "���");
				sendTf.setText("");
				sendTf.requestFocus();
				return;
			}
			int i = chatList.getSelectedIndex();
			if(i==-1||i==0) {//��üä��
				sendMessage(ChatProtocol3.CHATALL+ChatProtocol3.MODE1+str);
			}else { //�ӼӸ� ä��
				String id = chatList.getSelectedItem();
				sendMessage(ChatProtocol3.CHAT+ChatProtocol3.MODE1+id+";"+str);
			}
			sendTf.setText("");
			sendTf.requestFocus();
		}
	}//--actionPerformed

	public void routine(String line) {
		int idx = line.indexOf(ChatProtocol3.MODE1);
		String cmd = line.substring(0, idx);
		String data = line.substring(idx+1);
		if(cmd.equals(ChatProtocol3.CHATLIST)) {
			chatList.removeAll();
			chatList.add(listTitle);
			StringTokenizer st = new StringTokenizer(data, ChatProtocol3.MODE2);
			while(st.hasMoreTokens()) {
				chatList.add(st.nextToken());
			}
		}else if(cmd.equals(ChatProtocol3.CHAT)||
				cmd.equals(ChatProtocol3.CHATALL)){
			contentArea.append(data+"\n");
		}else if(cmd.equals(ChatProtocol3.MESSAGE)){
			idx = data.indexOf(ChatProtocol3.MODE2);
			cmd = data.substring(0,idx);
			data = data.substring(idx+1);
			new Message("FROM", cmd, data);
		}else if(cmd.equals(ChatProtocol3.MSGLIST)){
			msgAWT3 = new MsgAWT3(this, data);
			
		}
	}//--routine
	
	public void sendMessage(String msg) {
		out.println(msg);
	}

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
			id = chatList.getSelectedItem();
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
			if (mode.equals("TO")) {
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
			if(e.getSource()==send){
				sendMessage(ChatProtocol3.MESSAGE+
						ChatProtocol3.MODE1+id+ChatProtocol3.MODE2+ ta.getText());
			}
			setVisible(false);
			dispose();
		}
	}
}

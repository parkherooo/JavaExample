package net;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.util.Vector;

public class MsgAWT3 extends MFrame implements ActionListener{
	
	ChatClient3 client;
	String id;
	String title = "Message List";
	Button closeBtn;
	List list;
	Vector<MessageBean3> vlist;
	String str;
	String label[] = {"Fid", "Tid", "Msg"};
	
	public MsgAWT3(ChatClient3 client, String str) {
		super(300, 300, new Color(200, 100, 100));
		this.client = client;
		this.str = str;
		setTitle(title);
		list = new List();
		add(list, BorderLayout.CENTER);
		closeBtn = new Button("Close");
		closeBtn.addActionListener(this);
		Panel p = new Panel();
		p.add(closeBtn);
		add(p, BorderLayout.SOUTH);
		addListMsg();
		validate();
	}

	//aaa,bbb,π‰∏‘¿⁄;bbb,ccc,«œ¿Ã;
	public void addListMsg() {
		String s1[] = str.split(";");
		for (int i = 0; i < s1.length; i++) {
			String s2[] = s1[i].split(",");
			String item = "";
			item+="(F) "+s2[0] + "  (T) " + s2[1] + " : " + s2[2];
			list.add(item);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==closeBtn) {
			dispose();
		}
	}
}







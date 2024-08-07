package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import net.ChatServer1.Client1;

public class ChatServer2 {

	public static final int PORT = 8002;
	public ServerSocket server;
	public Vector<Client2> vc;
	
	public ChatServer2() {
		try {
			server = new ServerSocket(PORT);
			vc = new Vector<Client2>();
		} catch (Exception e) {
			System.err.println("Error in Server");
			System.exit(1);//���������� ����
		}
		System.out.println("*************************");
		System.out.println("ChatServer v2.0 Start********");
		System.out.println("*************************");
		try {
			while(true) {
				Socket sock = server.accept();//Client ������ ���
				Client2 ct = new Client2(sock);
				ct.start();
				vc.addElement(ct);
			}
		}catch (Exception e) {
			System.err.println("Error in Socket");
		}
	}
	
	//��ü���� �޼��� ������ ���
	public void sendAllMessage(String msg) {
		for (Client2 ct : vc) {
			ct.sendMessage(msg);
		}
	}
	
	//������ ������ Client�� vc���� ����
	public void removeClient(Client2 ct) {
		vc.remove(ct);
	}
	
	//CHATLIST:aaa;bbb;ȫ�浿;ccc;
	public String getIdList() {
		String list = "";
		for (Client2 ct : vc) {
			list+=ct.id+",";
		}
		return null;
	}
	
	//�Ű����� id�� Client2  ã��
	public Client2 findClient(String id) {
		Client2 fct = null;
		for (Client2 ct : vc) {
			if(id.equals(ct.id)) {
				fct= ct;
				break;
			}
		}
		return fct;
	}
	
	class Client2 extends Thread{
		
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id;
		
		public Client2(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(
						new InputStreamReader(
								sock.getInputStream()));
				out = new PrintWriter(sock.getOutputStream(), true);
				System.out.println(sock + " ���ӵ�...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				sendMessage("����� ���̵� �Է��ϼ��� : ");
				while(true) {
					String line = in.readLine();
					if(line==null) break;
					else routine(line);
				}
			} catch (Exception e) {
				removeClient(this);
				System.err.println(sock + " ������...");
				String str = ChatProtocol2.CHATLIST;
				str+=ChatProtocol2.MODE1+getIdList();
				sendAllMessage(str);
			}
		}
		
		//Client�� ���޵� �޼��� �м�
		public void routine(String line) {
			//CHATALL:������ ��ſ� �������Դϴ�.
			int idx = line.indexOf(ChatProtocol2.MODE1);
			String cmd = line.substring(0,idx);//CHAT
			String data = line.substring(idx+1); //������...
			if (cmd.equals(ChatProtocol2.ID)) {
				id = data;
				//���ο� �����ڰ� �߰��Ǹ鼭 CHATLIST ����
				sendAllMessage(ChatProtocol2.CHATLIST+ChatProtocol2.MODE1+getIdList());
				//���ο� ������ welcome �޼���
				sendAllMessage(ChatProtocol2.CHATALL+ChatProtocol2.MODE1+"["+id+"]���� �����Ͽ����ϴ�.");
				
			} else if(cmd.equals(ChatProtocol2.CHATALL)) {
				sendAllMessage(ChatProtocol2.CHATALL+ChatProtocol2.MODE1+"["+id+"] : "+ data);
				
			} else if(cmd.equals(ChatProtocol2.CHAT)) {
				//chat:bbb;�����
				idx = data.indexOf(ChatProtocol2.MODE2);
				cmd = data.substring(0,idx);//bbb
				data = data.substring(idx+1); //�����
				
				Client2 ct = findClient(cmd/*bbb*/);
				 if(ct!=null) {
					 //bbb���� ����
					 ct.sendMessage(ChatProtocol2.CHAT+ChatProtocol2.MODE1+"["+id+"(s)]"+data);
					 //aaa �ڽſ��� ����
					 sendMessage(ChatProtocol2.CHAT+ChatProtocol2.MODE1+"["+id+"(s)]"+data);
				 } else { //bbb�� ���� �����ڰ� �ƴ�.
					 sendMessage(ChatProtocol2.CHAT+ChatProtocol2.MODE1+"["+cmd+"]���� ���� �����ڰ� �ƴմϴ�.");
					 
				 }
			} else if(cmd.equals(ChatProtocol2.MESSAGE)) {
				//MESSAGE:bbb;��������?
				idx = data.indexOf(ChatProtocol2.MODE2);
				cmd = data.substring(0,idx);//bbb
				data = data.substring(idx+1); //��������?
				Client2 ct = findClient(cmd/*bbb*/);
				
				if(ct!=null) { //������������:���̵�;�޼��� 
					ct.sendMessage(ChatProtocol2.MESSAGE+ChatProtocol2.MODE1+id+ChatProtocol2.MODE2+data);
				} else {
					sendMessage(ChatProtocol2.CHAT+ChatProtocol2.MODE1+"["+cmd+"]���� ���� �����ڰ� �ƴմϴ�.");
				}
			}
		}
		
		public void sendMessage(String msg) {
			out.println(msg);
		}
	}//--Client2
	
	public static void main(String[] args) {
		new ChatServer2();
	}
}




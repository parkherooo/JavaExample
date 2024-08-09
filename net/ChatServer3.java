package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import net.ChatServer1.Client1;

public class ChatServer3 {

	public static final int PORT = 8003;
	public ServerSocket server;
	public Vector<Client3> vc;
	public ChatMgr3 mgr;
	
	public ChatServer3() {
		try {
			server = new ServerSocket(PORT);
			vc = new Vector<Client3>();
			mgr = new ChatMgr3();
		} catch (Exception e) {
			System.err.println("Error in Server");
			System.exit(1);//���������� ����
		}
		System.out.println("*************************");
		System.out.println("ChatServer v3.0 Start********");
		System.out.println("*************************");
		try {
			while(true) {
				Socket sock = server.accept();//Client ������ ���
				Client3 ct = new Client3(sock);
				ct.start();
				vc.addElement(ct);
			}
		}catch (Exception e) {
			System.err.println("Error in Socket");
		}
	}
	
	//��ü���� �޼��� ������ ���
	public void sendAllMessage(String msg) {
		for (int i = 0; i < vc.size(); i++) {
			//vc���� Client3�� ����.
			Client3 ct = vc.elementAt(i);//get ����
			//�����ϴ� Client3���� ��Ʈ������ �޼��� ����
			ct.sendMessage(msg);
		}
	}
	
	//������ ������ Client3�� vc���� ����
	public void removeClient(Client3 ct) {
		vc.remove(ct);
	}
	
	//CHATLIST:aaa;bbb;ȫ�浿;ccc;
	public String getIdList() {
		String list = "";
		for (Client3 ct : vc) {
			list+=ct.id+ChatProtocol3.MODE2;
		}
		return list;
	}
	
	//�Ű����� id�� Client3  ã��
	public Client3 findClient(String id) {
		Client3 ct = null;
		for (Client3 ct2 : vc) {
			//�Ű������� id�� ct�� id���� ���ٸ�
			if(ct2.id.equals(id)) {
				ct = ct2;
				break;
			}
		}
		return ct;
	}
	
	class Client3 extends Thread{
		
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id = "�͸�";
		
		public Client3(Socket sock) {
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
				while(true) {
					String line = in.readLine();
					if(line==null) {
						break;
					}else {
						routine(line);
					}
				}
			} catch (Exception e) {
				//Client3 ������ ���� ������
				removeClient(this);
				System.err.println(sock+"["+id+"] ������...");
				//CHATLIST������ ���� : �ٽ� Client3���� ê����Ʈ ������
				String msg = ChatProtocol3.CHATLIST;
				msg+=ChatProtocol3.MODE1+getIdList();
				sendAllMessage(msg);
			}
		}
		
		//Client�� ���޵� �޼��� �м�
		public void routine(String line) {
			int idx = line.indexOf(ChatProtocol3.MODE1);
			String cmd = line.substring(0, idx);
			String data = line.substring(idx+1);
			//ID:aaa;1234
			if(cmd.equals(ChatProtocol3.ID)) {
				idx = data.indexOf(ChatProtocol3.MODE2);
				cmd = data.substring(0, idx); //aaa
				data = data.substring(idx+1); //1234
				if(mgr.loginChk(cmd, data)) { //�α��� ���� : C(��������),T(����) 
					Client3 ct =findClient(cmd);
					if(ct!=null&&ct.id.equals(cmd)) {
						sendMessage(ChatProtocol3.ID+ChatProtocol3.MODE1+"C");
					} else {
						id = cmd;
						sendMessage(ChatProtocol3.ID+ChatProtocol3.MODE1+"T");
						sendAllMessage(ChatProtocol3.CHATLIST+ChatProtocol3.MODE1+getIdList());
						sendAllMessage(ChatProtocol3.CHATALL+ChatProtocol3.MODE1+"["+id+"]���� �����Ͽ����ϴ�.");
					}
				} else { //�α��ν���
					sendMessage(ChatProtocol3.ID+ChatProtocol3.MODE1+"F");
				}
			}else if(cmd.equals(ChatProtocol3.CHATALL)) {
				sendAllMessage(ChatProtocol3.CHATALL+
						ChatProtocol3.MODE1+"["+id+"]"+data);
			}else if(cmd.equals(ChatProtocol3.CHAT)) {
				idx = data.indexOf(ChatProtocol3.MODE2);
				cmd = data.substring(0, idx);
				data = data.substring(idx+1);
				Client3 ct = findClient(cmd);
				if(ct!=null) {
					ct.sendMessage(ChatProtocol3.CHAT+
							ChatProtocol3.MODE1+"["+id+"(S)]"+data);
					sendMessage(ChatProtocol3.CHAT+
							ChatProtocol3.MODE1+"["+id+"(S)]"+data);
				}else {
					sendMessage(ChatProtocol3.CHAT+
							ChatProtocol3.MODE1+
							"["+cmd+"]���� �����ڰ� �ƴմϴ�");
				}
			}else if(cmd.equals(ChatProtocol3.MESSAGE)) {
				idx = data.indexOf(ChatProtocol3.MODE2);
				cmd = data.substring(0, idx); //bbb
				data = data.substring(idx+1); //�����
				Client3 ct =findClient(cmd);
				MessageBean3 bean = new MessageBean3();
				bean.setFid(id);
				bean.setTid(cmd);
				bean.setMsg(data);
				mgr.insertMsg(bean); //DB���� 
				ct.sendMessage(ChatProtocol3.MESSAGE+ChatProtocol3.MODE1+id+ChatProtocol3.MODE2+data);
			}else if(cmd.equals(ChatProtocol3.MSGLIST)) {
				//MSGLIST:aaa,bbb,�����;bbb,ccc,���ù���;
				Vector<MessageBean3> vlist = mgr.getMsgList(id);
				String str = "";
				for (MessageBean3 bean : vlist) {
					str +=bean.getFid()+",";
					str +=bean.getTid()+",";
					str +=bean.getMsg()+ChatProtocol3.MODE2;
				}//--for
				sendMessage(ChatProtocol3.MSGLIST+
						ChatProtocol3.MODE1+str);
			}
		}
		
		public void sendMessage(String msg) {
			out.println(msg);
		}
	}//--Client3
	
	public static void main(String[] args) {
		new ChatServer3();
	}
}
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
			System.exit(1);//비정상적인 종료
		}
		System.out.println("*************************");
		System.out.println("ChatServer v2.0 Start********");
		System.out.println("*************************");
		try {
			while(true) {
				Socket sock = server.accept();//Client 접속을 대기
				Client2 ct = new Client2(sock);
				ct.start();
				vc.addElement(ct);
			}
		}catch (Exception e) {
			System.err.println("Error in Socket");
		}
	}
	
	//전체에게 메세지 보내는 기능
	public void sendAllMessage(String msg) {
		for (Client2 ct : vc) {
			ct.sendMessage(msg);
		}
	}
	
	//접속이 끊어진 Client를 vc에서 제거
	public void removeClient(Client2 ct) {
		vc.remove(ct);
	}
	
	//CHATLIST:aaa;bbb;홍길동;ccc;
	public String getIdList() {
		String list = "";
		for (Client2 ct : vc) {
			list+=ct.id+",";
		}
		return null;
	}
	
	//매개변수 id로 Client2  찾기
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
				System.out.println(sock + " 접속됨...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				sendMessage("사용할 아이디를 입력하세요 : ");
				while(true) {
					String line = in.readLine();
					if(line==null) break;
					else routine(line);
				}
			} catch (Exception e) {
				removeClient(this);
				System.err.println(sock + " 끊어짐...");
				String str = ChatProtocol2.CHATLIST;
				str+=ChatProtocol2.MODE1+getIdList();
				sendAllMessage(str);
			}
		}
		
		//Client에 전달된 메세지 분석
		public void routine(String line) {
			//CHATALL:오늘은 즐거운 수요일입니다.
			int idx = line.indexOf(ChatProtocol2.MODE1);
			String cmd = line.substring(0,idx);//CHAT
			String data = line.substring(idx+1); //오늘은...
			if (cmd.equals(ChatProtocol2.ID)) {
				id = data;
				//새로운 접속자가 추가되면서 CHATLIST 전송
				sendAllMessage(ChatProtocol2.CHATLIST+ChatProtocol2.MODE1+getIdList());
				//새로운 접속자 welcome 메세지
				sendAllMessage(ChatProtocol2.CHATALL+ChatProtocol2.MODE1+"["+id+"]님이 입장하였습니다.");
				
			} else if(cmd.equals(ChatProtocol2.CHATALL)) {
				sendAllMessage(ChatProtocol2.CHATALL+ChatProtocol2.MODE1+"["+id+"] : "+ data);
				
			} else if(cmd.equals(ChatProtocol2.CHAT)) {
				//chat:bbb;밥먹자
				idx = data.indexOf(ChatProtocol2.MODE2);
				cmd = data.substring(0,idx);//bbb
				data = data.substring(idx+1); //밥먹자
				
				Client2 ct = findClient(cmd/*bbb*/);
				 if(ct!=null) {
					 //bbb에게 보냄
					 ct.sendMessage(ChatProtocol2.CHAT+ChatProtocol2.MODE1+"["+id+"(s)]"+data);
					 //aaa 자신에게 보냄
					 sendMessage(ChatProtocol2.CHAT+ChatProtocol2.MODE1+"["+id+"(s)]"+data);
				 } else { //bbb가 현재 접속자가 아님.
					 sendMessage(ChatProtocol2.CHAT+ChatProtocol2.MODE1+"["+cmd+"]님이 현재 접속자가 아닙니다.");
					 
				 }
			} else if(cmd.equals(ChatProtocol2.MESSAGE)) {
				//MESSAGE:bbb;언제마쳐?
				idx = data.indexOf(ChatProtocol2.MODE2);
				cmd = data.substring(0,idx);//bbb
				data = data.substring(idx+1); //언제마쳐?
				Client2 ct = findClient(cmd/*bbb*/);
				
				if(ct!=null) { //프로토콜형식:아이디;메세지 
					ct.sendMessage(ChatProtocol2.MESSAGE+ChatProtocol2.MODE1+id+ChatProtocol2.MODE2+data);
				} else {
					sendMessage(ChatProtocol2.CHAT+ChatProtocol2.MODE1+"["+cmd+"]님이 현재 접속자가 아닙니다.");
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




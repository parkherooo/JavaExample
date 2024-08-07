package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer1 {
	public static final int PORT = 8001;
	ServerSocket server;
	//������ Client ��ü �����ϴ� ����
	Vector<Client1> vc;
	
	public ChatServer1() {
		try {
			server = new ServerSocket(PORT);
			vc = new Vector<Client1>();
		} catch (Exception e) {
			System.err.println("Error in Server");
			System.exit(1); //������ ����
		}
		System.out.println("************************************");
		System.out.println("*******ChatServer v1.0 Start********");
		System.out.println("************************************");
		try {
			while (true) {
				Socket sock = server.accept();
				Client1 ct = new Client1(sock); //Thread
				ct.start();
				//������ Client �� Vector ����
				vc.addElement(ct);
			}
			
		} catch (Exception e) {
			System.err.println("Error in Socket");
		}
	}
	//��ü �����ڿ��� �޼��� ������ ���
	public void sendAllMessage(String msg) {
		for (Client1 ct : vc) {
			ct.sendMessage(msg);
		}
	}
	
	//������ �������� Vector ���� Client ����
	public void removeClient(Client1 ct) {
		vc.remove(ct);
	}
	
	class Client1 extends Thread{
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id;
		
		public Client1(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				out = new PrintWriter(sock.getOutputStream(),true);
				System.out.println(sock + " ���ӵ�...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			try {
				//Client �� ���ʷ� �޴� �޼���
				sendMessage("����� ���̵� �Է��ϼ��� : ");
				//Client �� ������ id ����
				id = in.readLine();
				//������ ��� Client ���� Welcome �޼��� ����
				sendAllMessage("["+id+"]���� �����Ͽ����ϴ�.");
				String line = "";
				while (true) {
					line = in.readLine();
					if(line == null) break;
					sendAllMessage("["+id+"] : "+line);
				}
				in.close();
				out.close();
				sock.close();
			} catch (Exception e) {
				//Client ������ �������� Vector ���� �� �ڽ��� ����
				removeClient(this);
				System.err.println(sock + " ������...");
			}
		}
		public void sendMessage(String msg) {
			out.println(msg);
		}
	}
	
	public static void main(String[] args) {
		new ChatServer1();
	}
}

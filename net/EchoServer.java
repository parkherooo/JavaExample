package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	
	public static final int PORT = 8000;
	
	public EchoServer() {
		try {
			int cnt = 0;
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("EchoServer Start...");
			while (true) {
				Socket sock = server.accept(); //Client 대기
				EchoThread et = new EchoThread(sock);
				et.start();
				cnt++;
				System.out.println("Client" + cnt + " Socket");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	//Client 를 각자 대응하기 위한 Thread 상속 클래스
	class EchoThread extends Thread{
		
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		
		public EchoThread(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				out = new PrintWriter(sock.getOutputStream(),true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try { //Client 가 최초로 받는 메세지
				out.println("Hello Enter BYB to exit");
				while (true) {
					
					String line = in.readLine(); //대기상태
					
					if(line==null) {
						break;
					} else {
						out.println("Echo : "+line);
						if(line.equalsIgnoreCase("BYB")) {
							break;
						}
					}
				} //--while
				in.close();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		
	public static void main(String[] args) {
		new EchoServer();
	}
}

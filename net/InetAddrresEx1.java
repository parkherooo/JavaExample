package net;

import java.net.InetAddress;

public class InetAddrresEx1 {
	public static void main(String[] args) {
		try {
			//ip 및 도메인 객체화
			InetAddress add = InetAddress.getLocalHost();
			System.out.println("Host Name : "+ add.getHostName());
			System.out.println("Host Address : "+ add.getHostAddress());
			//도메인 -> ip 
			add = InetAddress.getByName("auction.co.kr");
			System.out.println("Auction IP : "+ add.getHostAddress());
			InetAddress adds[] = InetAddress.getAllByName("naver.com");
			for (int i = 0; i < adds.length; i++) {
				System.out.println("naver IP : " + adds[i]);
			}
 		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

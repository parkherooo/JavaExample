package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class URLEx1 {
	public static void main(String[] args) {
		String str = "https://search.naver.com:80/"
				+ "search.naver?where=nexearch"
				+ "&sm=top_sug.pre&fbm=0&acr=3&acq=%EC%9E%90%EB%B0%94&qdt=0&ie=utf8&"
				+ "query=java#top";
		try {
			URI uri = new URI(str);
			URL url = uri.toURL();
			System.out.println("Protocol : "+url.getProtocol());
			System.out.println("Host : "+url.getHost());
			System.out.println("Port : "+url.getPort());
			System.out.println("Path : "+url.getPath());
			System.out.println("Query : "+url.getQuery());
			System.out.println("Filename : "+url.getFile());
			System.out.println("Ref : "+url.getRef()); //특정한 화면 위치에 가고자 할때 id 값 = Ref
			url = new URL("http://jspstudy.co.kr");
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
			String line = "";
			while (true) {
				line = br.readLine();
				if(line==null) break;
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

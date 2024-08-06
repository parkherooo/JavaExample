package ch14;

import java.io.InputStream;

public class InputStreamEx1 {
	public static void main(String[] args) {
		InputStream is = System.in; //키보드
		//io의 메소드는 대부분 예외처리
		while (true) {
			try {
				int a = is.read(); //내부적인 스레드 : 입력 전에 대기상태
				if(a == -1 /*ctrl+z*/) break;
				System.out.print((char)a);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("종료");
	}
}

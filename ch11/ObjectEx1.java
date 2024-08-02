package ch11;
//import 필요 없는 경우 : 같은 패키지, java.lang 클래스들
import java.lang.*;

class Point1{}

public class ObjectEx1 {

	public static void main(String[] args) {
		Point1 p =new Point1();
		Point1 p1 =new Point1();
		System.out.println("클래스 이름 : "+p.getClass());
		//객체를 구분하는 정수값
		System.out.println("해쉬코드 : "+p.hashCode());
		System.out.println("해쉬코드 : "+p1.hashCode());
		System.out.println(p==p1);
		System.out.println(p.equals(p1));
		System.out.println("객체의 기본정보 : "+p.toString()); // 그냥 p 도 가능
		String s = new String("하하");
		System.out.println(s.toString());
	}
}

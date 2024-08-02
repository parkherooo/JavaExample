package ch11;

class Point3{}


public class StringEx1 {
	public static void main(String[] args) {
		Point3 p1 = new Point3();
		Point3 p2 = new Point3();
		System.out.println(p1==p2);
		p1=p2;
		//참조형의 ==는 객체 주소값(정수값) 비교
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2));
		int a = 10;
		int b = 10;
		//기본형의 ==는 값을 비교
		System.out.println(a==b);
		System.out.println("----------------------------------");
		String s1 = new String("Java");
		String s2 = new String("Java");
		//String : 클래수중에 유일 new 연산자 없이 객체 생성가능
		//String 저장소에 생성. 같은 문자열이면 같이 참조.
		String s3 = "Java";
		String s4 = "Java";
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s3==s4);
		System.out.println("----------------------------------");
		//문자열 equals : 문자열 내용비교
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s4));
		System.out.println("----------------------------------");
		String s5 = "APPLE";
		String s6 = "apple";
		System.out.println(s5.equals(s6));
		System.out.println(s5.equalsIgnoreCase(s6));
	}
}

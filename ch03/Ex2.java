package ch03;
/* 컴파일 : javac -d . 클래스명.java
	실행 : java 패키지명.클래스명*/
public class Ex2 {

	public static void main(String[] args) {
		System.out.println("success~");
		int a=1;
		int b=1;
		int a1 = a++;
		int b1 = ++b;
		System.out.println("a :"+ a);
		System.out.println("b :"+ b);
		System.out.println("a1 :"+ a1);
		System.out.println("b1 :"+ b1);
	}

}

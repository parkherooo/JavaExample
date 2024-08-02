package ch03;

public class Ex5 {

	public static void main(String[] args) {
		int a =10;
		int b =4;
		System.out.println((a==b)&(a>b));
		System.out.println((a==b)&&(a>b));
		int c= 0;
		System.out.println((a==b)&&(a/c>b));
		System.out.println((a!=b)|(a<b));
		System.out.println((a!=b)||(a<b));
		System.out.println("-----------------------------");
		System.out.println((a==b)^(a>b));
		System.out.println((a!=b)^(a>b));
	}

}

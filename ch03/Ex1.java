package ch03;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		int a = 10;
		int b = 3;
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a%b);
		Scanner sc =new Scanner(System.in);
		int c =sc.nextInt();
		if (c%2==0) {
			System.out.println(c+"짝수입니다.");
		}
		else {
			System.out.println(c+"홀수입니다");
		}
	}

}

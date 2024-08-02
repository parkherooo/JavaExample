package ch02;


import java.util.Scanner;
public class Ex8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요 : ");
		String name =sc.nextLine();
		System.out.print("나이를 입력하세요 : ");
		int age =sc.nextInt();
		System.out.printf("\n %s님의 나이는 %d살입니다.",name,age);
	}

}

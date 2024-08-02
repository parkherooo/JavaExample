package ch04;

import java.util.Scanner;

public class Ex6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score, grade;
		System.out.println("점수를 입력해주세요");
		score = sc.nextInt();
		System.out.println("학년을 입력해주세요");
		grade = sc.nextInt();
		if (grade == 4) {
			if (score >= 70) {
				System.out.println("합격입니다.");
			} else {
				System.out.println("불합격입니다");
			}
		} else {
			if (score >= 60) {
				System.out.println("합격입니다.");
			} else {
				System.out.println("불합격입니다");
			}
		}
	}
}

package ch04;

public class Ex8 {
	public static void main(String[] args) {
		// 문제1 1~10합
		int sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0, sum5 = 0;
		for (int i = 1; i < 11; i++) {
			sum1 += i;
			if (i == 10) {
				System.out.print(i + " = ");
			} else {
				System.out.print(i + " + ");
			}

		}
		System.out.println(sum1);
		// 문제2 1~30사이 3의배수합
		for (int j = 1; j < 31; j++) {
			if (j % 3 == 0) {
				sum2 += j;
			}
		}
		System.out.println("문제 2번 답: " + sum2);
		// 문제3 1~30사이의 값중 짝수와 홀수합
		for (int k = 1; k < 31; k++) {
			if (k % 2 == 0) {
				sum3 += k;
			} else {
				sum4 += k;
			}
		}
		System.out.println("문제 3번답 짝수합 :" + sum3 + "홀수 합 :" + sum4);
		// 문제사 1~50사이 3,6,9합
		for (int l = 1; l < 51; l++) {
			if (l % 10 == 3 || l % 10 == 6 || l % 10 == 9) {
				sum5 += l;
			} else if (l / 10 == 3) {
				sum5 += l;
			}
		}
		System.out.println("문제 4번 답 : " + sum5);
	}
}

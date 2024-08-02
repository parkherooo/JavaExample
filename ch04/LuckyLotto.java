package ch04;

import java.util.Arrays;
import java.util.Random;

public class LuckyLotto {
	public static void main(String[] args) {
		int arr[] = getLotto();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}

	public static int[] getLotto() {
		int lotto[] = new int[6];
		Random rd = new Random();
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = rd.nextInt(45) + 1;
			// 중복번호 제거
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(lotto);
		return lotto;
	}
}

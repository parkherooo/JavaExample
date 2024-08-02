package ch04;

import java.util.Arrays;
import java.util.Random;

public class LuckyLotto3 {
	public static void main(String[] args) {
		int arr[] = getLotto();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}

	public static int[] getLotto() {
		int lotto[] = new int[6];
		for (int i = 0; i < lotto.length; i++) {
			int num = (int)(Math.random()*45)+1;
			if(isDuplication(lotto, num)) {
				i--;
			} else {
				lotto[i] = num;
			}
		}
		Arrays.sort(lotto);
		return lotto;
	}
	//중복이면 true 아니면 else;
	public static boolean isDuplication(int arr[],int num) {
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			str+= arr[i]+" ";
		}
		return str.contains(String.valueOf(num));
	}
}

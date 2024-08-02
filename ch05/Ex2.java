package ch05;

import java.util.Iterator;

public class Ex2 {
	public static void main(String[] args) {
		int arr[][]=new int[2][3];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j]=i+j;
				System.out.println("arr["+i+"]["+j+"]="+arr[i][j]);
			}
		}
		System.out.println("------------------------------");
		//문제 1 arr2의 모든 요소의 합을 구하시오.
		int arr2[][]= {{1,2},{3,4,5},{6},{7,8},{9,10}};
		double sum = 0;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				sum += arr2[i][j];
			}
		}
		System.out.println("합은 :"+sum);
		System.out.println("------------------------------");
	//문제2. arr3의 평균을 구하시오.
		double arr3[][] = {{1.0},
								       {2.3,3.4},
								       {4.5,6.2,4.3},
								       {9.0}};
		sum = 0;
		double a = 0;
		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr3[i].length; j++) {
				a++;
				sum+=arr3[i][j];
			}
		}
		System.out.println("평균 : "+sum/a);
		System.out.println("------------------------------");
		//문제3. arr4의 평균과 합을 각각 구하시오.
		int arr4[][][] = { { {1, 2, 3}, {4, 5}, {6, 7, 8, 9}},
				                     { {10, 11}, {12, 13, 14}, {15}, {22}},
				                     { {16, 17, 18, 19, 20},{22, 23, 24}}
									};
		sum = 0;
		a = 0;
		for (int i = 0; i < arr4.length; i++) {
			for (int j = 0; j < arr4[i].length; j++) {
				for (int k = 0; k < arr4[i][j].length; k++) {
					a++;
					sum+=arr4[i][j][k];
				}
			}
		}
		System.out.println("평균 : "+sum/a+" 합 : "+sum);
	}
}

package ch11;
/*멀티 Thread에서 동기화가 가능한 StringBuffer
 * 단일 Thread에서 동기화가 불가능한 StringBuilder*/
public class PalindromeEx1 {

	public static final int MAX = 100000;

	public static void main(String[] args) {
		/*
		 * 앞에서부터 읽을 때나 뒤에서부터 읽을 때나 모양이 같은 수를 대칭수(palindrome)라고 합니다. 대칭수(palindrome)인
		 * 585는 2진수로 나타내도 1001001001가 되어 여전히 대칭수입니다.
		 */

		// 문제1.10진수의 대칭수인 100,000 이하 숫자의 합은 얼마입니까?
		int sum = 0;
		for (int i = 0; i < MAX; i++) {
			String str1 = String.valueOf(i);
			String str2 = "";
			int len = str1.length();
			for (int j = len - 1; j > -1; j--) {
				str2 += str1.charAt(j);
			}
			if (str1.equals(str2))
				sum += i;
		}
		System.out.println("10진수 대칭수의 합 : " + sum);
		
		 int k =1;
		 sum = 0;
		 while (k<=MAX) {
			String s = String.valueOf(k);
			StringBuilder sb = new StringBuilder(s);
			if(s.equals( sb.reverse().toString()))
				sum+=k;
			k++;
		}
		 System.out.println("1번답 : "+sum);
		 
		// 문제2.2진수의 대칭수인 100,000 이하 숫자의 합은 얼마입니까?
		int sum1 = 0;
		for (int i = 0; i < MAX; i++) {
			String str1 = Integer.toBinaryString(i);
			String str2 = "";
			int len = str1.length();
			for (int j = len - 1; j > -1; j--) {
				str2 += str1.charAt(j);
			}
			if (str1.equals(str2))
				sum1 += i;
		}
		System.out.println("2진수 대칭수의 합 : " + sum1);
		
		 k =1;
		 sum = 0;
		 while (k<=MAX) {
			String s = Integer.toBinaryString(k);
			StringBuilder sb = new StringBuilder(s);
			if(s.equals( sb.reverse().toString()))
				sum+=k;
			k++;
		}
		 System.out.println("2번답 : "+sum);
		 
		// 문제3.10진수과 2진수으로 모두 대칭수인 100,000 이하 숫자의 합은 얼마입니까?
		int sum2 = 0;
		for (int i = 0; i < MAX; i++) {
			String str1 = Integer.toBinaryString(i);
			String str2 = "";
			String str3 = String.valueOf(i);
			String str4 = "";
			int len = str1.length();
			for (int j = len - 1; j > -1; j--) {
				str2 += str1.charAt(j);
			}
			 len = str3.length();
			for (int j = len - 1; j > -1; j--) {
				str4 += str3.charAt(j);
			}
			
			if (str1.equals(str2) && str3.equals(str4))
				sum2 += i;
		}
		System.out.println("10진수과 2진수 모두 대칭수인 수의 합 : " + sum2);
		
		 k =1;
		 sum = 0;
		 while (k<=MAX) {
			String s1 = String.valueOf(k);
			String s2 = Integer.toBinaryString(k);
			StringBuilder sb1 = new StringBuilder(s1);
			StringBuilder sb2 = new StringBuilder(s2);
			if(s1.equals( sb1.reverse().toString())&&s2.equals(sb2.reverse().toString()))
				sum+=k;
			k++;
		}
		 System.out.println("3번답 : "+sum);

	}
}

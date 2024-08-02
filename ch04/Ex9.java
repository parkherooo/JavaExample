package ch04;

public class Ex9 {
	public static void main(String[] args) {
		//while 문을 이용해서 1~10까지의 합을 구하시오
		int i =0;
		int sum = 0;
		while(i<11) {
			sum+=i;
			i++;
		}
		System.out.println(sum);
		
		while (true) {
			System.out.println("반복문 탈출");
			if(true) break;
		}
		do {
			System.out.println("무조건 한번은 실행");
		} while(false);
		
	}
}

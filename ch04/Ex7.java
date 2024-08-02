package ch04;

public class Ex7 {
	public static void main(String[] args) {
		//for 문을 이용해서 1~10까지의 합을 구하시오.
		int sum = 0;
		for(int i=1;i<11;i++) {
			sum+=i;
		}
		System.out.println("1~10까지의 합 : "+sum);
		int j=0;
		for(;j<11;j++) {
			System.out.println("j : "+j);
		}
		for(;;) {
			System.out.println("무한반복");
		}
	}
}

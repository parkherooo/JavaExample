package ch04;

import java.util.Scanner;

public class Ex4 {
	public static void main(String[] args) {
		/*Month(1~12)입력을 하면 각각 계절에 맞는
		 *	 봄 : 3~5 
		 *여름 : 6~8
		 *가을 : 9~11
		 *겨울 : 12~2
		 *5 입력하면 '봄입니다'
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Month (1~12)를 입력하세요 : ");
		int month = sc.nextInt();
		
		if(month>=3&&month<=5) {
			System.out.println(month+"월은 봄 입니다.");
		}
		else if(month>=6&&month<=8) {
			System.out.println(month+"월은 여름입니다.");
		}
		else if(month>=9&&month<=11) {
			System.out.println(month+"월은  가을입니다.");
		}
		else if(month==12||month==1||month==2) {
			System.out.println(month+"월은 겨울입니다.");
		}
		else {
			System.out.println("해당되는 계절이 없습니다.");
		}
		
		System.out.println("-----------swich문--------------");
		
		switch (month) {
		case 3,4,5: 
			System.out.println(month+"월은 봄입니다.");
			break;
		
		case 6,7,8: 
			System.out.println(month+"월은 여름입니다.");
			break;
		
		case 9,10,11: 
			System.out.println(month+"월은 가을입니다.");
			break;
		
		case 12,1,2: 
			System.out.println(month+"월은 겨울입니다.");
			break;
		
		default:
			System.out.println("해당되는 계절이 없습니다.");
		}
	}
}

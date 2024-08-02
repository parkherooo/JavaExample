package ch02;

public class Ex2 {

	public static void main(String[] args) {

		//변수는 위에 선언한 것은 밑에 사용가능
		int a = 10;
		int b = a;
		int c = 20;
		System.out.println(a);
		System.out.println(a+b);
		System.out.println(a+b+c);
		
		if(a>=10) {
			System.out.println("실행되나요?");
			int e = 10;
			int g = b+10;
			
		}	
		//int f = e+10;
	}

}

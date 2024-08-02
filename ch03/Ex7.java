package ch03;

public class Ex7 {

	public static void main(String[] args) {
		int a = 0;
		if(a%2==0)System.out.println("짝수");
		else System.out.println("홀수");
		String str = (a%2==0)?"짝수":"홀수";
		System.out.println(str);
		int b = Math.min(10, 20);
		int c = 10;
		int d = 20;
		int e = b>c?b:c;
		System.out.println(e);
		
		int f =-10;
		int g = f>0?f:-f;
		System.out.println(g);
		System.out.println(Math.abs(f));
	}

}

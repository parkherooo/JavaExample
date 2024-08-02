package ch07;



public class CastingEx1 {
	public static void main(String[] args) {

		int a = 1234567;
		long l = a; //묵시적 형변환
		 System.out.println(a + " : " + l);
		 short s = (short)a; //명시적 형변환
		 System.out.println(a + " : "+ s);
	}
}

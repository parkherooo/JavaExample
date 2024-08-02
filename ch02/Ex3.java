package ch02;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Ex3 {

	public static void main(String[] args) {
		//데이터 타입(Data Type) : 기본형(8개) + 참조형(+α)
		//정수형(4)
		byte b = 10;
		short s =10;
		int i = 20;
		long l = 10;
		
		//실수형(2)
		float f = 3.14F; //리터럴 값 앞 또는 뒤에 F/f 표기
		double d =3.14;
		
		//문자형(1)
		char c = 'A';
		char c1 = '자';
		
		String /*참조형*/ str = "자바";//문자열
		//불린형(1)
		boolean b1 = true; //값을지정하지않으면 false 
		
		System.out.println(Short.MAX_VALUE);
		short s1 = (short)32768;
		System.out.println(s1);
		//크기의 변화에 대해서 명시적 형변환과 묵시적 형변환
		
		int i2=200;
		long l2 = i2;
		long l3 = 300;
		int i3= (int)l3; //명시적 형 변환
		
	}

}

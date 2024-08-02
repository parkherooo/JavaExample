package ch10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx3 {

	public static void main(String[] args) {
		Scanner s =null;
		try {
			int a, b;
			s = new Scanner(System.in);
			System.out.print("첫번째 숫자 : ");
			a = s.nextInt();
			System.out.print("두번째 숫자 : ");
			b =s.nextInt();
			System.out.println(a+"/"+b+"="+a/b);
			//다중 catch 는 예외 객체의 순서를 지켜야한다
			// 상위 Exception 클래스 먼저오면 절대안됨. -> 컴파일오류
		} catch (ArithmeticException e) {
			System.out.println("0으로 나누면 안됩니다.");
			
		} catch(InputMismatchException e) {
			System.out.println("숫자만 입력해야합니다.");	
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			s.close(); //사용후에 반드시 close 해야함.
		}//--try-catch-finally
	}

}

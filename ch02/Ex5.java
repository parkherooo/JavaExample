package ch02;

public class Ex5 {
   public static void main(String[] args) {
      // Data Type : 기본형(8개) + 참조형(class 타입) : SUN + 외부 lib + 현재 선언한 클래스
      int a =10;
      // 클래스 : 객체를 만드는 틀 -> 필드(객체 속성) 및 메소드(객체 기능)
      // String 클래스 : 문자열을 객체화 시킨 클래스 ex) 문자열 길이 : length()
      // Math 클래스 : 수학을 객체화 시킨 클래스 ex) PT(원주율 필드), 올림, 내림
      // "hwrthrthh;st;mserasdfaesfasdfasdfgwe%%"
      String str = "hwrthrthh;st;mserasdfaesfasdfasdfgwe%%";
      System.out.println(str.length());
      System.out.println(str.toUpperCase()); // 대문자로 변환
      
      // 반지름이 5인 원의 넓이를 구하시오.
      System.out.println(5*5*Math.PI);
            
   }

}
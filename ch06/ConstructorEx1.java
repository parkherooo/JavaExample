package ch06;

class Constructor1{
	//생성자(메소드): 클래스명과 동일한 이름 선언된 메소드, 리턴 타입 자체가 없음
	Constructor1(){
		System.out.println("디폴트 생성자");	
	}
	Constructor1(int i){
		System.out.println("매개변수 int 생성자");
		
	}
	Constructor1( String str){
		System.out.println("매개변수  String 생성자");
		
	}
}
public class ConstructorEx1 {
	public static void main(String[] args) {
		Constructor1 c1 =new Constructor1();
		Constructor1 c2 =new Constructor1(22);
		Constructor1 c3 =new Constructor1("테스트");
		String str = new String(); //15개의 생성자 : 다양한 환경에서 객체가 생성
 	}
}

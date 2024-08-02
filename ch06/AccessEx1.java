package ch06;

/*접근제어자 : 클래스, 필드, 메소드,
 * 1. private(0.1%) 외부 접근불가
 * 2. protected(0.01%) 상속 -> public, 상속 x -> private
 * 3. public(99.9%)
 * 
 * */

class Access1{
	public int a= 0; // 어디에서나 접근가능
	protected int b = 0; //상속 또는 같은 패키지일때 가능
	private int c = 0; //자신의 클래스 안에서만 접근가능
	
}

/*AcceessEx1.java : 클래스명.java 선언된 클래스만 public 이고 
	다른 클래스(Acceess1)는 public 선언하면 안됨 */
public class AccessEx1 {
	public static void main(String[] args) {
	
	}
}

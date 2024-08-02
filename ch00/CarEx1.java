package ch00;

//객체, 클래스
//속성(변수), 기능(메소드)

//클래스 : 객체를 만드는 틀 <--붕어빵 틀
//객체의 속성과 기능 
class Car1{
	//변수(필드) : 객체의 속성 <- 무조건 () 없다.
	String carName;
	int velocity;
	String carColor;
	
	//메소드 : 객체의 기능 <- 무조건 () 있다.
	void speedUp() {
		velocity++;
	}
	void speedDown() {
		velocity--;
	}
	void stop( ) {
		velocity = 0;
	}
}
public class CarEx1 {
	public static void main(String[] args) {
		String s = new String(" erfwewfwrwe");
				//현재 문자열의 길이를 리턴하세요
		int len = s.length();
		System.out.println(len);
		prn("하이~");
		int a= Math.abs(-10);
		//System.out.println(a);
		
		Car1 c1= new Car1();
		c1.carName = "타이칸";
		c1.carColor = "화이트";
		c1.speedUp();
		System.out.println(c1.carName+","+c1.carColor+","+c1.velocity);
	
		Car1 c2 = new Car1();
		c2.carName = "소나타";
		c2.carColor =  "블랙";
		c2.velocity = 100;
		
		System.out.println(c2.carName+","+c2.carColor+","+c2.velocity);
	
		System.out.println(c1);
		System.out.println(c2);
	}
	public static void prn(String s){
		System.out.println("출력 :" + s);
		
	}
}

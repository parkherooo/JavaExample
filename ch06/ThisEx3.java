package ch06;

class Super{
	String name;
	void prn() {
		System.out.println("Name : "+ name);
	}
}
class Sub extends Super{
	int name;
	@Override
	void prn() {
		System.out.println("Super Name : "+super.name);
		System.out.println("name : "+name);
	}
}

public class ThisEx3 {
	public static void main(String[] args) {
		Sub sub =new Sub();
		sub.prn();
		//문제 이 위치에서 Sub 클래스의 this 와 super 키워드 사용가능? no
		//sub 레퍼런스 변수로 super 클래스 prn 호출가능? -> 불가능 
	}
}

package ch07;

class Animal{
	void move() {
		System.out.println("동물아 움직여라~~");
	}
}

class Bird extends Animal{
	String name = "새";
	
	@Override
	void move() {
		System.out.println(name+"날아라");
	}
}

class Fish extends Animal{
String name = "물고기";
	
	@Override
	void move() {
		System.out.println(name + "헤엄쳐라");
	}
	
}

class Cheetah extends Animal{
String name = "치타";
	
	@Override
	void move() {
		System.out.println(name + "달려라");
	}
}

public class CastingEx2 {
	public static void main(String[] args) {
		Animal ani[] = new Animal[3];
		ani[0] = new Bird();
		ani[1] = new Fish();
		ani[2] = new Cheetah();
	
		for (int i = 0; i < ani.length; i++) {
			//정적 바인딩 : 컴파일 시점에 결정. static 
			//동적 바인딩(Override) : 하위클래스의 메소드가 호출. 실행시점 결정
			ani[i].move(); 
		}
		
		Fish f= new Fish();
		Object obj = f;
		
		Animal ani2 = new Animal();
		//강제 Casting 경우 컴파일 시점에서 에러남
		Bird d= (Bird)ani2;
		
	}
}
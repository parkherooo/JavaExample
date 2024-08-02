package ch07;
//종속관계클래스
class Car1 /*2대 클래스*/{
	int velocity;
	
	void speedUp() {
		velocity++;
	}
	
	void speedDown(){
		velocity--;
		if(velocity<0) 
			velocity=0;
	}
	
	void stop() {
		velocity=0;
	}
}

class Bus1 extends Car1{
	@Override
	void speedUp() {
		super.speedUp();
		if(velocity>100)
			velocity=100;
	}
}

class Taxi1 extends Car1{
	@Override
	void speedUp() {
		velocity+=5;
		
	}
	
	@Override
	void speedDown() {
		velocity-=5;
		if(velocity<0) 
			velocity=0;
	}
}

public class InheritanceEx1 {

	public static void main(String[] args) {

	}

}

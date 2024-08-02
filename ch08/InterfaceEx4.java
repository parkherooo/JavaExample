package ch08;

//추상클래스에는 반드시 추상메소드가 선언이 되어야 함.  o x ? x
abstract class Tv{
	String color;
	boolean power;
	int ch;
	
	void onOffPower() {
		power=!power;
	}
	void upCh() {ch++;}
	void downCh() {ch--;}
	
	abstract void setModel();
}

interface RemoteControl{
	void turnOn();
	void turnOff();
	
}

class SMTv extends Tv implements RemoteControl{

	@Override
	void setModel() {
	}
	@Override
	public void turnOff() {
	}
	@Override
	public void turnOn() {
	}
}

class LGTv extends Tv implements RemoteControl{

	@Override
	void setModel() {
	}
	@Override
	public void turnOff() {
	}
	@Override
	public void turnOn() {
	}
}

public class InterfaceEx4 {
	public static void main(String[] args) {
		
	}
}

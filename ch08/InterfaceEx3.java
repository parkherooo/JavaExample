package ch08;

interface InterfaceA3{
	void prnA();
	
}

interface InterfaceB3{
	void prnB();
	
}
class MyClass3 implements InterfaceA3, InterfaceB3{

	@Override
	public void prnB() {
	}

	@Override
	public void prnA() {
	}
	
}

public class InterfaceEx3 {
	public static void main(String[] args) {
		
	}	
}

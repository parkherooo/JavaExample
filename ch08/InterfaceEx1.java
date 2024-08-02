package ch08;

interface Calc{
	//추상 메소드 : abstract 는 사용하지 않아도 자동으로 됨.
	void plus(int a , int b);
	
}

class Function extends Object implements Calc{

	@Override
	public void plus(int a, int b) {}
	
}

class Graphics implements Calc{
	@Override
	public void plus(int a, int b) {
	}
}

public class InterfaceEx1 {

	public static void main(String[] args) {
		
	}

}

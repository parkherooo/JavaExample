package ch06;

class This1{
	public This1(This2 t2) {
		
	}
}
class This2{
	public This2() {
		This1 t1 = new This1(this/*자신의 객체*/);
	}
}

public class ThisEx1 {
	public static void main(String[] args) {
	
	}
}

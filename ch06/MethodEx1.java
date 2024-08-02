package ch06;

class Method1{
	int /*리턴타입*/abs/*메소드명*/(int num/*매개변수*/)/*선언부*/{
		if(num<0)
			num =-num;
		return num;
	}
	void prn(int a,int b) {
		int c = a+b;
		System.out.println(a+"+"+b+"="+c);
	}
}

public class MethodEx1 {
	public static void main(String[] args) {
		Method1 m1 = new Method1();
		int a =m1.abs(-10);
		System.out.println(a);
		m1.prn(20, 30);
	}
}

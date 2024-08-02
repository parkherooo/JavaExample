package ch08;

interface Interface2{
	//자동으로 static final
	//인터페이스는 일반적인 필드 선언불가
	int a =10;
	void prn();
}

//인터페이스 끼리상속가능<-다중상속가능
interface Interface2_1 extends Interface2{
	void prn2();
}

class MycClass2 implements Interface2_1{
	@Override
	public void prn() {
	}@Override
	public void prn2() {
	}
}

public class InterfaceEx2 {
	public static void main(String[] args) {
		
	}
}

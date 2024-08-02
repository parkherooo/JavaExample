package ch06;

class Ann1{
	void prn() {}
}
class Ann2 extends Ann1{
	@Override //<- 오버라이딩이라고 표시해주는 역할
	void prn() {} 
}

//Annotation : 주석
public class AnnotationEx1 {
	public static void main(String[] args) {
		char c ='a';
		if (Character.isSpace(c)) {
			System.out.println("c는 공백문자입니다. ");
		} else {
			System.out.println("c는 공백문자가 아닙니다. " + c);
		}
		prn();
	}
	@Deprecated //<-@가 Annotation
	public static void prn() {
		
	}
}

package ch06;

class Access2{
	private String name;
	private int age;
	
	//Getter vs Setter : getXxx, SetXxx	
	private void setName(String name) {
		this.name = name;
	}
	public String  getName() {
		return name;
	}
	public int  getAge() {
		return age;
	}
	public void  setAge(int age) {
		if(age<0)
			age = 0;
		this.age = age;
	}
}


public class AccessEx2 {
	public static void main(String[] args) {
		Access2 a1 = new Access2();
		//a1.name = "홍길동";
		//a1.age = -10;
		a1.setAge(-10);
		System.out.println(a1.getAge());
		
	}
}

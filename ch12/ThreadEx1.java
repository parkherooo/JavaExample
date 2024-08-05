package ch12;

class Thread1 extends Thread{
	
	String name;
	public Thread1(String name) {
		this.name = name;
	}
	
	//강제성은 아니지만 반드시 Override 
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(200);//0.2초
				System.out.println(name + " : "+ i);
			} catch (Exception e) {
			}
		}
	}
}

public class ThreadEx1 {

	public static void main(String[] args) {
		Thread1 t1 = new Thread1("첫번째");
		Thread1 t2 = new Thread1("두번째");
		t1.start(); //내부적으로 run 메소드 호출
		t2.start();//스레드 스케줄러에게 등록->스케줄러가 run 메소드 호출
	}
}

package ch10;

public class ExceptionEx2 {

	public static void main(String[] args) {
		try {
			int arr[] = new int[3];
			arr[0]=  1;
			arr[1]=  1;
			arr[2]=  1;
			arr[3]=  1;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	//예외 발생에 관계없이 무조건실행
			System.out.println("finally");
		}
		//try 는 catch or finally 랑 같이 사용해야함
		try {
			
		} finally {
			
		}
	}

}

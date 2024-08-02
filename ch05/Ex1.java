package ch05;

public class Ex1 {
	public static void main(String[] args) {
		//1배열의변수선언
		int arr[];
		//2.배열의 크기 지정(불변)
		arr = new int[5];
		//배열값을할당한다
		arr[0] =1;
		arr[1] =2;
		arr[2] =3;
		arr[3] =4;
		arr[4] =5;
		//arr[5] =6;
		//4.배열의 출력
		for (int  i= 0;  i< arr.length; i++) {
			System.out.println("arr["+i+"] = "+arr[i]);
		}
		System.out.println("----------------------------");
		int arr1[] = new int[3];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i]=i*10;
			System.out.println("arr1["+i+"] = "+arr1[i]);
		}
		//배열선언동시에 할당
		int arr2[]= {1,2,3,4,5};
		String str[] = {"java","jsp","flutter","Spring"};
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}
}

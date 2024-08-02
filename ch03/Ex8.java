package ch03;

public class Ex8 {

	public static void main(String[] args) {
		int a =10;
		int b =20;
		int c = 30;
		int sum = a+b+c;
		System.out.println(sum);
		
		int arr[];
		arr = new int [3];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		System.out.println(arr[0]+arr[1]+arr[2]);
		
		int arr1[]=new int[5];
		int sum1 = 0;
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = i*10;
			sum1+= arr1[i];
		}
		System.out.println(sum1);
	}

}

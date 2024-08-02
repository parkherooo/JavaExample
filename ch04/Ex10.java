package ch04;

public class Ex10 {
	public static void main(String[] args) {
		int a =10;
		while (true) {
			if(a==10) 
				break;
			System.out.println("a : " +a);
			a++;
		}
		int sum = 0;
		for(int i = 1;true;i++) {
			sum+=i;
			if(sum>100) break;
		}
		System.out.println(sum);
		
		int sum1 =0;
		int n =0;
		for(int j =1;true;j++) {
			sum1+=j;
			if(sum1>100) {
				sum1-=j;
				n = j-1;
				System.out.println("n값 : "+n+" sum1 값 : "+sum1);
				break;
			}
		}
		for(int i = 1; i<11; i++) {
			if(i%2==0) {
				System.out.print(i+ " ");
			}
		}
		System.out.println();
		for(int i =1; i<11;i++) {
			if(i%2!=0)
				continue;
			System.out.print(i+" ");
		}
		System.out.println();
		sum = 0;
		for(int i =1;i<21;i++) {
			if(i%3!=0) {
				continue;
			}
			sum+=i;
			if(i>3)//+먼저출력하고 i인걸 생각하면 18뒤에 왜 +가 안나오는지 알게됨
				System.out.print("+"); 
			System.out.print(i);
		}
		System.out.print("="+sum);
	}
}

package ch14;

import java.io.InputStream;

public class InputStreamEx1 {
	public static void main(String[] args) {
		InputStream is = System.in; //Ű����
		//io�� �޼ҵ�� ��κ� ����ó��
		while (true) {
			try {
				int a = is.read(); //�������� ������ : �Է� ���� ������
				if(a == -1 /*ctrl+z*/) break;
				System.out.print((char)a);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("����");
	}
}

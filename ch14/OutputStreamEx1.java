package ch14;

import java.io.OutputStream;

public class OutputStreamEx1 {
	public static void main(String[] args) {
		int a ='a';
		char b = 'b';
		char c = '��';
		try {
			OutputStream os = System.out; //�ܼ�â�� ��½�Ʈ��
			os.write(a);
			os.write(b);
			os.write(c);
			os.flush(); //��Ʈ���� �����ִ� data �� ����
			os.close(); //������� �ʴ� ��Ʈ���� �ݵ�� �ݴ´�
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

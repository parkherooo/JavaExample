package ch14;

import java.io.FileWriter;

public class FileWriteEx1 {

	public static void main(String[] args) {
		String str = "�츮���� ���ǿ��� ��� ������ �޲�����,\n"
				+ "���� �ű⿣ ���̻� �����ϵ� �ƹ��͵� ���� �� ����.\n"
				+ "������ ������ ������ �Ǹ� �η����� ������ ���ǿ� �����̰�\n"
				+ "�;��Ѵ�.";
		try {
			//������ ȣ��� ������ �������
			FileWriter fw = new FileWriter("ch14/bbb.txt");
			char intxt[] = new char[str.length()];
			str.getChars(0, str.length(), intxt, 0);
			fw.write(intxt);
			//fw.write(str);
			fw.flush();
			fw.close();
			System.out.println("����");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

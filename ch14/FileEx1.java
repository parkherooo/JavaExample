package ch14;

import java.io.File;

public class FileEx1 {

	public static void main(String[] args) {
		File f = new File("ch14/FileEx1.java");
		if(f.exists()) {
			System.out.println("파일 이름 : " + f.getName());
			System.out.println("상대 경로 : " + f.getPath());
			System.out.println("절대 경로 : " + f.getAbsolutePath());
			System.out.println("쓰기 가능 : " + f.canWrite());
			System.out.println("읽기 가능 : " + f.canRead());
			System.out.println("파일 크기 : " + f.length()+"byte");
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
	}

}

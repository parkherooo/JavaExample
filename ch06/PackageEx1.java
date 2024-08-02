package ch06;

import com.mysql.cj.jdbc.Driver;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.Date;

public class PackageEx1 {
	public static void main(String[] args) throws Exception {
		Driver d =new Driver();
		Frame f = new Frame();
		Button btn = new Button();
		ActionEvent ae;
		//Date : java.util , java.sql
		//많이 사용하는 클래스를 import
		Date date = new Date();
		//적게 사용하는 클래스 full name
		java.sql.Date date1= new java.sql.Date(0);
	}
}

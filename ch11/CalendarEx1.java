package ch11;

import java.util.Calendar;

public class CalendarEx1 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.print("오늘의 날짜는");
		System.out.print(cal.get(Calendar.YEAR)+ "년 ");
		System.out.print(cal.get(Calendar.MONTH)+1+ "월 ");
		System.out.print(cal.get(Calendar.DAY_OF_MONTH)+ "일 ");
		System.out.println();
		int ampm = cal.get(Calendar.AM_PM);
		if(ampm==Calendar.AM)
			System.out.println("현재 시간은 AM");
		else
			System.out.println("현재 시간은 PM");
		System.out.print(cal.get(Calendar.HOUR)+ "시 ");
		System.out.print(cal.get(Calendar.MINUTE)+ "분 ");
		System.out.print(cal.get(Calendar.SECOND)+ "초 ");
		
	}
}

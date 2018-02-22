package util;

import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		printDate(cal);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.YEAR, 2007);
		cal2.set(Calendar.MONTH, 1); // 원래 달 - 1 꼭
		cal2.set(Calendar.DATE, 22);
		printDate(cal2);
		
		cal2.set(2007, 10, 18);
		cal2.add(Calendar.DATE, 4000);
		printDate(cal2);
	}
	
	public static void printDate(Calendar cal) {
		String[] days = {"일", "월", "화", "수", "목", "금", "토"};
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK);	//1(일요일), 7(토요일)
		int am = cal.get(Calendar.AM_PM);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		
		System.out.println(year + "년 " + month + "월 " + date + "일 " + days[day-1] + "요일 " +
				(am==0?"오전":"오후") + " " + hour + ":" + minute);
	}
}
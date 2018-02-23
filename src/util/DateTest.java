package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		printDate(date);
		
		/*
		 * 특정 시간 세팅(2000/08/04)
		 */
		
		//year는 1900년 기준, month는 0부터 시작
		Date d1 = new Date(100, 7, 4);
		Date d2 = new Date(100, 7, 4, 14, 30, 30);
		//1970.1.1 기준
		Date d3 = new Date(24L * 60 * 60 * 1000 * 365 * 30);
		printDate(d1);
		printDate(d2);
		printDate2(d3);
	}
	
	public static void printDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(date));
	}
	
	@SuppressWarnings("deprecation")
	public static void printDate2(Date d) {
		//년도 (+1900)
		
		int year = d.getYear();
		
		//월(0-11)
		int month = d.getMonth();
		
		//일
		int date = d.getDate();
		
		//시
		int hour = d.getHours();
		
		//분
		int minutes = d.getMinutes();
		
		//초
		int seconds = d.getSeconds();
		
		System.out.println((year+1900) + "년" + (month + 1) + "월 " + date + "일 " + hour + ":" +
		minutes + ":" + seconds);
	}
}

package com.kh.ex05.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {
	//날짜 관련 API
	
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);		// 오늘 날짜 출력
		System.out.println(date.getTime()); 	//오늘의 날짜를 long의 ms로 가져옴
		System.out.println(System.currentTimeMillis()); 	//오늘의 날짜를 long의 ms로 가져옴
		// -> 1,650,272,178,283 = 1970년부터 오늘 현재까지 흐른 ms 시간
		// -> 1,650,272,178 = 1970년부터 오늘 현재까지 흐른 ms 시간
		// 시간동기화 프로토콜 : SNTP(simple Network Time Protocol)
		
		
		Date date2 = new Date(System.currentTimeMillis());
		System.out.println(date2);
		
		// Date format을 통해 원하는 양식으로 변경하는 방법
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd요일 E요일 hh시 mm분 ss초");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd(E) hh:mm:ss초");
		System.out.println(sdf1.format(date2));
		System.out.println(sdf2.format(date2));
		
		
		// Calendar : 날짜를 다루는 클래스
		// 특징 : 자체 생성이 불가능!!
//		Calendar cal = new Calendar(); // 추상클래스라 생성 불가!
		Calendar cal = Calendar.getInstance(); // 대신 생성해주는 메소드 호출
//		System.out.println(cal.toString().replace(",", ",\n"));
		
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1); // +1
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.AM_PM));
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
//		String dateStr = sdf1.format(cal.getTime());
		String dateStr = sdf1.format(cal.getTimeInMillis());
		System.out.println(dateStr);

		// 날짜를 지정하는 방법 : GregorianCalendar를 권장
		GregorianCalendar gc = new GregorianCalendar(2001,6-1,10);
		System.out.println(sdf1.format(gc.getTime()));

		// 날짜간 비교
		System.out.println(gc.after(cal));
		System.out.println(gc.before(gc));
		
		// 날짜간 연산
		System.out.println(cal.getTimeInMillis()- gc.getTimeInMillis());
		System.out.println(new Date(cal.getTimeInMillis()- gc.getTimeInMillis()));
		
		// 결론
		// 날짜에 관련된 연산은 자바의 api보다 DB 기능을 적극적으로 활용할것 권장합니다.
		// sysdate = 오늘 날짜 출력 가능. 이외 좋은 함수가 많다.


		
		
	}

}

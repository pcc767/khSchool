package com.kh.ex05.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {
	//��¥ ���� API
	
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);		// ���� ��¥ ���
		System.out.println(date.getTime()); 	//������ ��¥�� long�� ms�� ������
		System.out.println(System.currentTimeMillis()); 	//������ ��¥�� long�� ms�� ������
		// -> 1,650,272,178,283 = 1970����� ���� ������� �帥 ms �ð�
		// -> 1,650,272,178 = 1970����� ���� ������� �帥 ms �ð�
		// �ð�����ȭ �������� : SNTP(simple Network Time Protocol)
		
		
		Date date2 = new Date(System.currentTimeMillis());
		System.out.println(date2);
		
		// Date format�� ���� ���ϴ� ������� �����ϴ� ���
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy�� MM�� dd���� E���� hh�� mm�� ss��");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd(E) hh:mm:ss��");
		System.out.println(sdf1.format(date2));
		System.out.println(sdf2.format(date2));
		
		
		// Calendar : ��¥�� �ٷ�� Ŭ����
		// Ư¡ : ��ü ������ �Ұ���!!
//		Calendar cal = new Calendar(); // �߻�Ŭ������ ���� �Ұ�!
		Calendar cal = Calendar.getInstance(); // ��� �������ִ� �޼ҵ� ȣ��
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

		// ��¥�� �����ϴ� ��� : GregorianCalendar�� ����
		GregorianCalendar gc = new GregorianCalendar(2001,6-1,10);
		System.out.println(sdf1.format(gc.getTime()));

		// ��¥�� ��
		System.out.println(gc.after(cal));
		System.out.println(gc.before(gc));
		
		// ��¥�� ����
		System.out.println(cal.getTimeInMillis()- gc.getTimeInMillis());
		System.out.println(new Date(cal.getTimeInMillis()- gc.getTimeInMillis()));
		
		// ���
		// ��¥�� ���õ� ������ �ڹ��� api���� DB ����� ���������� Ȱ���Ұ� �����մϴ�.
		// sysdate = ���� ��¥ ��� ����. �̿� ���� �Լ��� ����.


		
		
	}

}

package org.test.common.base.other;

import java.util.Date;

public class DateTest {
	
	
	
	public static void main(String[] args) {
		Date date = new Date();
		date.setTime(date.getTime()+1000L);
		System.out.println("date : "+date);
		System.out.println("date.after() : "+date.after(new Date()));
		Date date2 = new Date();
		System.out.println("date.before() : "+date2.before(new Date()));
	}
	
	
	
}

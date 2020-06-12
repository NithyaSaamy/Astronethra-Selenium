package com.auto.Listeners;

import java.util.Calendar;
import java.util.Date;

public class CurrentDate {
	 public String getDateFormat()
	 {
			Date date= new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DATE);
			int year = cal.get(Calendar.YEAR);
			int hours = cal.get(Calendar.HOUR_OF_DAY);
			int minutes = cal.get(Calendar.MINUTE);
			String mm = Integer.toString(month);;
			String dd = Integer.toString(day);
			String hrs = Integer.toString(hours);
			String min = Integer.toString(minutes);
			if(month < 10){
				mm = "0" + month;
			}
			if(day < 10){
				dd = "0" + day;
			}
			if(hours < 10){
				hrs = "0" + hours;
			}
			if(minutes < 10){
				min = "0" + minutes;
			}
			return mm + "-" + dd + "-" + year + " " + hrs + "_" + min;
	 }

}

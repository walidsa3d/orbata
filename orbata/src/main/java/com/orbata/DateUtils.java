package com.orbata;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
//	MMddyyHHmmss
	public Date parseDate(String dateString, String formatString){
		DateFormat format = new SimpleDateFormat(formatString);
		Date date;
		try {
			date = format.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return date;
	}

}

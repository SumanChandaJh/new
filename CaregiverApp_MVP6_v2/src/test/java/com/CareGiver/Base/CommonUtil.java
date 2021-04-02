package com.CareGiver.Base;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CommonUtil {

	public CommonUtil() {
	}

	/**
	 * Get current date in 'M/dd/yyyy' format
	 * 
	 * @return
	 */
	public static String getCurrentDate() {

		String currentDate = null;
		DateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy");
		Date date = new Date();
		currentDate = dateFormat.format(date);

		System.out.println("Current Date in 'M/dd/yyyy' :" + currentDate);
		return currentDate;
	}

	public static String getCurrentTime() {

		String currentTime = null;
		DateFormat dateFormat = new SimpleDateFormat("h:mm a");
		Date date = new Date();
		currentTime = dateFormat.format(date);

		System.out.println("Current Time in 'h:mm a' :" + currentTime);
		return currentTime;
	}

	public static boolean isValidFormat(String format, String date) {
		LocalDateTime ldt = null;
		DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(format, Locale.ENGLISH);

		try {
			ldt = LocalDateTime.parse(date, fomatter);
			String result = ldt.format(fomatter);
			return result.equals(date);
		} catch (DateTimeParseException e) {
			try {
				LocalDate ld = LocalDate.parse(date, fomatter);
				String result = ld.format(fomatter);
				return result.equals(date);
			} catch (DateTimeParseException exp) {
				try {
					LocalTime lt = LocalTime.parse(date, fomatter);
					String result = lt.format(fomatter);
					return result.equals(date);
				} catch (DateTimeParseException e2) {
					// Debugging purposes
					// e2.printStackTrace();
				}
			}
		}

		return false;
	}

	public static String roundOffMin(String roundOffProc, String dateTimeFormat) {

		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int unroundedMinutes = calendar.get(Calendar.MINUTE);
		int mod = unroundedMinutes % 1;

		if (roundOffProc.equalsIgnoreCase("next")) {
			calendar.add(Calendar.MINUTE, 1);
			calendar.set(Calendar.SECOND, 0);
		} else if (roundOffProc.equalsIgnoreCase("previous"))
			calendar.add(Calendar.MINUTE, unroundedMinutes == 0 ? -1 : -mod);

		SimpleDateFormat format = new SimpleDateFormat(dateTimeFormat);
		String formattedDate = format.format(calendar.getTime());
		return formattedDate;
	}

	public static String getDateTimeFormat(String dateTimeFormat) {
		String dateTime = "";
		DateFormat dateFormat = new SimpleDateFormat(dateTimeFormat);
		Date date = new Date();
		dateTime = dateFormat.format(date);

		System.out.println("Current Time in 'h:mm a' :" + dateTime);
		return dateTime;
	}

	public static long getDateTimeDifference(String start, String end, String dateTimeFormat) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(dateTimeFormat, Locale.ENGLISH);
		Date startDate = format.parse(start);
		Date endDate = format.parse(end);
		long diff = startDate.getTime() - endDate.getTime();		
		return diff;
	}
	


}

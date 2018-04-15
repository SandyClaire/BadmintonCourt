package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Const {

	public static final String INVALID = "Error: the booking is invalid!";
	public static final String ACCEPTED = "Success: the booking is accepted!";
	public static final String CONFLICTS = "Error: the booking conflicts with existing bookings!";
	public static final String CANCELLED = "Error: the booking being cancelled does not exist!";

	public static int penaltyCalculate(int value, boolean isWeekday) {
		if (isWeekday)
			return (int) (value * 0.5);
		return (int) (value * 0.25);
	}

	public static int valueCalculate(int startTime, int endTime,
			boolean isWeekday) {
		int value = 0;
		for (int i = startTime; i < endTime; i++) {
			value += oneHourValueJudge(i, isWeekday);
		}
		return value;
	}

	private static int oneHourValueJudge(int time, boolean isWeekday) {
		int value = 0;
		switch (time) {
		case 9:
		case 10:
		case 11:
			if (isWeekday) { // 是工作日
				value = 30;
			} else { // 是周末
				value = 40;
			}
			break;
		case 12:
		case 13:
		case 14:
		case 15:
		case 16:
		case 17:
			value = 50;
			break;
		case 18:
		case 19:
			if (isWeekday) { // 是工作日
				value = 80;
			} else { // 是周末
				value = 60;
			}
			break;
		case 20:
		case 21:
			value = 60;
			break;
		default:
			break;
		}
		return value;
	}

	/**
	 * isWeekday
	 * 
	 * @param dayString
	 * @return true：工作日 false：周末
	 */
	public static boolean isWeekday(String dateString) {
		boolean dayType = false;
		Calendar calendar = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return dayType;
		}
		if (date == null) {
			return dayType;
		}
		calendar.setTime(date);
		switch (calendar.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.MONDAY:
		case Calendar.TUESDAY:
		case Calendar.WEDNESDAY:
		case Calendar.THURSDAY:
		case Calendar.FRIDAY:
			dayType = true;
			break;
		case Calendar.SATURDAY:
		case Calendar.SUNDAY:
			dayType = false;
			break;
		default:
			break;
		}
		return dayType;
	}
}

package main;

public class Util {
	
	public int valueCheck(int time, boolean isWeekDay) {
		int value = 0;
		switch (time) {
		case 9:
		case 10:
		case 11:
			if (isWeekDay) {  // 是工作日
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
			if (isWeekDay) {  // 是工作日
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
	 * @param dayString
	 * @return -1：错误
	 *          0：工作日
	 *          1：周末
	 */
	public int isWeekday(String dayString) {
		int dayType= -1;
		
		return dayType;
	}
}

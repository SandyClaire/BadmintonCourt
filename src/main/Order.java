package main;

import java.util.Arrays;

public class Order {

	String id;
	String day;
	String time;
	int startTime;
	int endTime;
	char court;
	boolean isReserve;
	int money;

	public Order(String id, String day, String time, char court,
			boolean isReserve) {
		this.id = id;
		this.day = day;
		this.time = time;
		this.startTime = Integer.parseInt(time.substring(0, 2));
		this.endTime = Integer.parseInt(time.substring(6, 8));
		this.court = court;
		this.isReserve = isReserve;
        this.money = money(day, court, court, isReserve);
	}
	
	private int money(String date, int startTime, int endTime, boolean isReserve) {
		boolean isWeekday = Util.isWeekday(date);
		int value = Util.valueCalculate(startTime, endTime, isWeekday);
		if (isReserve) {
			return value;
		} else {
			return Util.penaltyCalculate(value, isWeekday);
		}
	}

	public boolean isReserveConflict(Order order) {
		if (court != order.court || !day.equalsIgnoreCase(order.day)
				|| !isReserve) {
			return false;
		}
		int[] array = { startTime, order.endTime, startTime, order.endTime };
		Arrays.sort(array);
		if (array[1] == endTime || array[1] == order.endTime) {
			return false;
		}
		return true;
	}

	public boolean isOrderExist(Order order) {
		if (!id.equalsIgnoreCase(order.id) || !isReserve
				|| court != order.court) {
			System.out.println(court);
			System.out.println(order.court);
			return false;
		}
		if (!day.equalsIgnoreCase(order.day)
				|| !time.equalsIgnoreCase(order.time)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		if (isReserve)
			return new StringBuilder(day).append(" ").append(time).append(" ")
					.append(money).append("元").toString();
		return new StringBuilder(day).append(" ").append(time).append(" ")
				.append("违约金").append(" ").append(money).append("元").toString();
	}
}

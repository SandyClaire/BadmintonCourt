package main;

public class Order{
	
	String id;
	String day;
	String time;
	int startTime;
	int endTime;
	char court;
	boolean isReserve;
	int money;
	
	public Order(String id, String day, String time, char court, boolean isReserve) {
		this.id = id;
		this.day = day;
		this.time = time;
		this.startTime = Integer.parseInt(time.substring(0, 2));
		this.endTime = Integer.parseInt(time.substring(6, 8));
		this.court = court;
		this.isReserve = isReserve;
		boolean isWeekday = Util.isWeekday(day);
		int value = Util.valueCalculate(startTime, endTime, isWeekday);
		if (isReserve) {
			this.money = value;
		} else {
			this.money = Util.penaltyCalculate(value, isWeekday);
		}		
	}
	
	@Override
	public String toString() {
		if (isReserve) 
			return new StringBuilder(day).append(" ").append(time).append(" ").append(money).append("元").toString();
        return new StringBuilder(day).append(" ").append(time).append(" ").append("违约金").append(" ").append(money).append("元").toString();		
	}
}

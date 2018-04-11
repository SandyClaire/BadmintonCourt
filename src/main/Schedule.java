package main;

public class Schedule {
	
	String id;
	String day;
	String time;
	int startTime;
	int timeLast;
	char court;
	boolean isReserve;
	int money;
	
	public Schedule(String id, String day, String time, int startTime,
			int timeLast, char court, boolean isReserve, int money) {
		this.id = id;
		this.day = day;
		this.time = time;
		this.startTime = startTime;
		this.timeLast = timeLast;
		this.court = court;
		this.isReserve = isReserve;
		this.money = money;
	}
}

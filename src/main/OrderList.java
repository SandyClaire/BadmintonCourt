package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class OrderList extends ArrayList<Order> {

	public void addOrder(Order order) {
		if (order.isReserve) {
			for (int i = 0; i < size(); i++) {
				if (get(i).isReserveConflict(order)) {
					System.out.println("" + Const.CONFLICTS);
					return;
				}
			}
			add(order);
			System.out.println("" + Const.ACCEPTED);
		} else {
			for (int i = 0; i < size(); i++) {
				if (get(i).isOrderExist(order)) {
					remove(i);
					add(order);
					System.out.println("" + Const.ACCEPTED);
					return;
				}
			}
			System.out.println("" + Const.CANCELLED);
		}
	}

	private int printCourt(char court) {
		System.out.println("场地:" + court);
		int value = 0;
		for (int i = 0; i < size(); i++) {
			if (get(i).court == court) {
				System.out.println(get(i));
				value += get(i).money;
			}
		}
		System.out.println("小计： " + value + "元");
		return value;
	}

	public void printTotal() {
		sort(new OrderComparator());
		int value = 0;
		System.out.println("收入汇总");
		System.out.println("---");
		value += printCourt('A');
		System.out.println();
		value += printCourt('B');
		System.out.println();
		value += printCourt('C');
		System.out.println();
		value += printCourt('D');
		System.out.println("---");
		System.out.println("总计： " + value + "元");
	}

	class OrderComparator implements Comparator<Order> {

		@Override
		public int compare(Order o1, Order o2) {
			// TODO Auto-generated method stub
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String date1 = new StringBuilder(o1.day).append(" ")
					.append(o1.time.substring(0, 5)).toString();
			String date2 = new StringBuilder(o2.day).append(" ")
					.append(o2.time.substring(0, 5)).toString();
			long time1 = 0L;
			long time2 = 0L;
			try {
				time1 = format.parse(date1).getTime();
				time2 = format.parse(date2).getTime();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				return 0;
			}
			return (int) (time1 - time2);
		}
	}
}

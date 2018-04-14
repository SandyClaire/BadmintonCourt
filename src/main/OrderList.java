package main;

import java.util.ArrayList;

public class OrderList extends ArrayList<Order> {
	
	public int printCourt(char court) {
		System.out.println("场地:" + court);
		int value = 0;
		for (int i = 0; i < size(); i++) {
			if (get(i).court == court) {
				System.out.println(get(i));
				value += get(1).money;
			}
		}
		System.out.println("小计： " + value + "元");
		return value;
	}

	public void printTotal() {
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
}

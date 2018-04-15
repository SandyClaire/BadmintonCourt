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
                if (isReserveConflict(get(i), order)) {
					System.out.println("" + Util.CONFLICTS);
					return;
				}
			}
		    add(order);
		    System.out.println("" + Util.ACCEPTED);
	      } else {
			for (int i = 0; i < size(); i++) {
	              if (isOrderExist(get(i), order)) {
					remove(i);
					add(order);
					System.out.println("" + Util.ACCEPTED);
					return;
				}  
		    }	
			System.out.println("" + Util.CANCELLED);
	   }
   }
   
   private boolean isReserveConflict(Order order1, Order order2) {
	   if (order1.court != order2.court || !order1.day.equalsIgnoreCase(order2.day) || !order1.isReserve) {
		   return false;
	   }
	   int[] array = {order1.startTime, order1.endTime, order2.startTime, order2.endTime};
	   Arrays.sort(array);
	   if (array[1] == order1.endTime || array[1] == order2.endTime) {
		return false;
	}	   
	   return true;
   }
   
   private boolean isOrderExist(Order listOrder, Order order) {
	   if (!listOrder.id.equalsIgnoreCase(order.id) || !listOrder.isReserve || listOrder.court !=order.court) {	
		   System.out.println(listOrder.court);
		   System.out.println(order.court);
		   return false;
	   }
	   if (!listOrder.day.equalsIgnoreCase(order.day) || !listOrder.time.equalsIgnoreCase(order.time)) {
		return false;
	   }
	   return true;
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
			String date1 = new StringBuilder(o1.day).append(" ").append(o1.time.substring(0, 5)).toString();
			String date2 = new StringBuilder(o2.day).append(" ").append(o2.time.substring(0, 5)).toString();
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

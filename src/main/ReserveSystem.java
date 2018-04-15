package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ReserveSystem {
	public static void main(String[] args) {

		OrderList list = new OrderList();
		Scanner scanner = new Scanner(System.in);

		// 不断输入
		while (true) {

			System.out.println("请输入预定信息： ");
			String[] infos = scanner.nextLine().split(" ");
			if (infos.length == 1 && infos[0].equalsIgnoreCase("")) {
				list.printTotal();
			} else if (isInfoCorrect(infos)) {
				Order order = new Order(infos[0], infos[1], infos[2],
						infos[3].charAt(0), isReserve(infos.length));
				list.addOrder(order);
			}
		}
	}

	private static boolean isReserve(int length) {
		if (length == 4) {
			return true;
		}
		return false;
	}

	// 判断字符数组格式正确性
	private static boolean isInfoCorrect(String[] array) {

		if (array.length != 4 && array.length != 5) {
			System.out.println("1" + Const.INVALID);
			System.out.println("" + array.length);
			return false;
		}
		if (!array[0].matches("^[U]{1}[0-9]{3}$")) {
			System.out.println("2" + Const.INVALID);
			return false;
		}

		if (array[1].length() != 10 || array[2].length() != 11) {
			System.out.println("3" + Const.INVALID);
			return false;
		}
		if (!array[2]
				.matches("^[0-9]{2}[:]{1}[0]{2}[~]{1}[0-9]{2}[:]{1}[0]{2}$")) {
			System.out.println("4" + Const.INVALID);
			return false;
		}
		int startTime = Integer.parseInt(array[2].substring(0, 2));
		int endTime = Integer.parseInt(array[2].substring(6, 8));
		if (endTime - startTime <= 0) {
			System.out.println("5" + Const.INVALID);
			System.out.println("startTime: " + startTime + " endTime: "
					+ endTime);
			return false;
		}
		String time = new StringBuilder(array[1]).append(" ")
				.append(array[2].substring(0, 5)).toString();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = null;
		try {
			date = dateFormat.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("6" + Const.INVALID);
			return false;
		}
		if (date == null || (date.getTime() - System.currentTimeMillis() < 0)) {
			System.out.println("7" + Const.INVALID);
			return false;
		}
		if (!array[3].matches("^[ABCD]{1}$")) {
			System.out.println("8" + Const.INVALID);
			return false;
		}
		if (array.length == 5 && !array[4].equals("C")) {
			System.out.println("9" + Const.INVALID);
			return false;
		}
		return true;
	}
}

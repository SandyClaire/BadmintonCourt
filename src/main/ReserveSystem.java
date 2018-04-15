package main;

import java.util.Scanner;

public class ReserveSystem {
		
	public static void main(String[] args) {		
		
		OrderList list = new OrderList();
		Scanner scanner = new Scanner(System.in); 
				
		// 不断输入
        while(true){
        	       
        	System.out.println("请输入预定信息： ");        	
        	String[] infos = scanner.nextLine().split(" ");
        	if (infos.length == 1 && infos[0].equalsIgnoreCase("")) {
        		list.printTotal();                     	
			} else if (Util.isInfoCorrect(infos)) {
				Order order = new Order(infos[0], infos[1], infos[2], infos[3].charAt(0), Util.isReserve(infos.length));
				list.addOrder(order);
			}    	
        } 
	}
}

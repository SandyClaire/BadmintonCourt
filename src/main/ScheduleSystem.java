package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



public class ScheduleSystem {

	public static void main(String[] args) {
		
		Map<String, Map<String, Schedule>> datas = new HashMap<String, Map<String,Schedule>> ();
			
		// 总计
		int total = 0;
		
		// 不断输入
        while(true){
        	Scanner scanner = new Scanner(System.in);
        
        	System.out.println("请输入信息： ");
        	
        	String[] infos = scanner.nextLine().split(" ");
        	
        	// 判断字符数组格式正确性
        	if (infos.length != 4 || infos.length != 5) {
				System.out.println("Error: the booking is invalid!");
			}
        	
        	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	Date date = null;
        	try {
				date = dateFormat.parse(infos[1]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("Error: the booking is invalid!");
			}
        	if (date == null || (date.getTime() - System.currentTimeMillis() <= 0)) {
        		System.out.println("Error: the booking is invalid!");
			}
        	
        	int startTime = Integer.parseInt(infos[2].substring(0, 1));
        	
        	
        	
        	
        	
        }
        
        
        
        
        
	}

}

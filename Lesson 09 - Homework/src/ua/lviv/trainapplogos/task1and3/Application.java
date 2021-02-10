/*
 * Owner's Copyright and so on... (2021)
 * */
package ua.lviv.trainapplogos.task1and3;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * The {@code Application} represents operations with Enumerations
 * @author usr
 * @see ua.lviv.trainapplogos.task1and3#Application
 * @category Enumeration
 * @version 1.0.1
 * */
public class Application {
	public static void main(String[] args) throws WrongInputConsoleParametersException {
		
		/* using of Scanner for input month from Keyboard (Stream: System.in) */
		Scanner sc = new Scanner(System.in);
		
		/* variable with name of month */
		String month_str; 	
		
		while (true) { //make continuous working of console application
			System.out.println("\n> Enter month: ");
			
			/*Scan month from line*/
			month_str = sc.next().toUpperCase();
					
			Months month; 
			/* Parse Seasons into array of Seasons */
			Seasons[] seasons = Seasons.values();
			
			/*m Checking existing of month and return Enumeration's constant of it */
			month = monthExists(month_str);
			
			if (month != null) { // if entered month exists
				/* Task 1: Output name of month */
				System.out.println("> #1: The month " + month_str + " is exists"); 
				
				/* Task 2: Parse all months with the same season into array of Month and output them */
				System.out.println("> #2: All months with the same season:");
				Months[] samemonths = returnMonths(2, month.getSeason().name(), 0);
				
				/* Task 3: Parse all months with the same amount of days into array of Month and output them */
				System.out.println("> #3: All months with the same amount of days:");
				Months[] samedays = returnMonths(3, null, month.getDays());
				
				/* Task 4: Parse all months with less amount of days into array of Month and output them */
				System.out.println("> #4: All months with less amount of days:");
				Months[] lessdays =  returnMonths(4, null, month.getDays());
						
				/* Task 5: Parse all months with more amount of days into array of Month and output them */
				System.out.println("> #5: All months with more amount of days:");
				Months[] moredays = returnMonths(5, null, month.getDays());
						
				/* Task 6: Output the next season */
				int nextSeasonInd = month.getSeason().ordinal() + 1;
				if (nextSeasonInd == 4)	nextSeasonInd = 0;
					
				System.out.println("> #6: The next season is " + seasons[nextSeasonInd].name());
				
				/* Task 7: Output the previous season */
				int previousSeasonInd = month.getSeason().ordinal() - 1;
				if (previousSeasonInd == -1) previousSeasonInd = 3;
					
				System.out.println("> #7: The previous season is " + seasons[previousSeasonInd].name());
				
				/* Task 8: Parse all months with odd amount of days into array of Month and output them */
				System.out.println("> #8: All months with odd amount of days:");
				Months[] odddays = returnMonths(8, null, month.getDays());
						
				/* Task 9: Parse all months with even amount of days into array of Month and output them */
				System.out.println("> #9: All months with even amount of days:");
				Months[] evendays = returnMonths(9, null, month.getDays());
						
				/* Task 10: Output is entered month has odd amount of days */
				if (month.getDays() % 2 == 0) {
					System.out.println("> #10: The month " + month_str + " has odd amount of days");
				} else {
					System.out.println("> #10: The month " + month_str + " hasn't odd amount of days");
				}
				
				System.out.println("___________________________________________________________________\n");
			
			} else { // call custom WrongInputConsoleParametersException with wrong name of month
				System.out.println("> #1: Month doesn't exist");
				throw new WrongInputConsoleParametersException(month_str);
			}
		}
	}
	
	/**
	 * @author usr
	 * @param month_str - name of month
	 * @return instance of Month
	 *   */
	public static Months monthExists(String month_str) {
		Months[] months = Months.values(); //parse enumeration into array of Enum's constants
		Months month = null;
		
		/* Check existing of month and save it into month instance*/
		for (Months month_val : months) {
			if (month_val.name().equalsIgnoreCase(month_str)) {
				month = month_val;
				break;
			} 
		}
		return month; //return appropriate Enumeration's constant
	}
	
	/**
	 * @author usr
	 * @param func - number of function which we want to use; season - name of season; days - days in month
	 * @return Array of Month
	 * */
	public static Months[] returnMonths (int func, String season, int days) {
		Months[] months = Months.values();
		ArrayList <Months> months_res = new ArrayList<>();
		boolean flag = false; // if checking statement is true flag will be true
		
		for (Months month : months) {
			//func is equal number of task
			switch  (func) {
			case 2:
				if (month.getSeason().name() == season) flag = true;
				break;
			case 3:
				if (month.getDays() == days) flag = true;
				break;
			case 4:
				if (month.getDays() < days) flag = true;
				break;
			case 5:
				if (month.getDays() > days) flag = true;
				break;
			case 8:
				if (month.getDays() % 2 == 0) flag = true;
				break;
			case 9:
				if (month.getDays() % 2 != 0) flag = true;
				break;
			}
			
			if (flag) {
				months_res.add(month); // Add month to ArrayList
				System.out.println("   -" + month.name()); // Output name of month
			}
		}
		return months_res.toArray(new Months[0]); // Convert ArrayList to Array of Month and return them
	}
	
}
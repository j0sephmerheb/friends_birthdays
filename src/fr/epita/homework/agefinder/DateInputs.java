package fr.epita.homework.agefinder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;


public class DateInputs {
	public String currentDate;
	public int dayDiff;

	SortedMap<Integer, String> friendsBdays = new TreeMap<Integer, String>();

	// Input Today's Date
	public void getTodayDate() {
		System.out.println("Please write today date in this format: dd/mm/yyyy");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		currentDate = scanner.nextLine();
	}

	
	// Input Friends Names and Birthdays
	public void getDates() throws ParseException {
		System.out.println("Please write your friends names and birthdays in this format: FirstName dd/mm/yyyy");
		System.out.println("Press 0 once done");

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String answer = "";

		while (true) {
			if (!answer.equals("0")) {
				answer = scanner.nextLine();
				if (answer.contains(" ")) {
					String[] birthdayDates = answer.split(" ");

					String friendName = birthdayDates[0];
					String friendBdayDate = birthdayDates[1];
					
					dayDiff = calcDate(currentDate,friendBdayDate);
					friendsBdays.put(dayDiff, friendName);
				}
			} 
			else {
				// Print the output
				friendsBdays.forEach((d, n) -> {
					System.out.println(n + " in " + d + " days");
				});
				return;
			}
		}
	};


	// Calculate Date
    public int calcDate(String d1, String d2) throws ParseException{
        Date date1 = new SimpleDateFormat("dd/MM").parse(d1);  
        Date date2 = new SimpleDateFormat("dd/MM").parse(d2);

        int diff = (int) ((date2.getTime() - date1.getTime())  / (1000*60*60*24)) ;
  
        if ( diff < 0) {
        	diff = 365 - diff;
        }
        
        return diff;  
	}

}

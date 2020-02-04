package fr.epita.homework.launcher;
import java.text.ParseException;

import fr.epita.homework.agefinder.DateInputs;

public class launcher {

	public static void main(String[] args) throws ParseException {		
		DateInputs myAge = new DateInputs();
		
		myAge.getTodayDate();
		myAge.getDates();	
	}

}

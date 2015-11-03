package com.alucarweb.util;

import java.util.Calendar;

public class DateUtil {
	
	public static int daysBetween(Calendar firstDay, Calendar secondDay){
	    Calendar dayOne = (Calendar) firstDay.clone();
	    Calendar dayTwo = (Calendar) secondDay.clone();

	    if (dayOne.get(Calendar.YEAR) == dayTwo.get(Calendar.YEAR)) {
	        return Math.abs(dayOne.get(Calendar.DAY_OF_YEAR) - dayTwo.get(Calendar.DAY_OF_YEAR));
	    }
        
	    if (dayTwo.get(Calendar.YEAR) > dayOne.get(Calendar.YEAR)) {
            Calendar temp = dayOne;
            dayOne = dayTwo;
            dayTwo = temp;
        }
        int extraDays = 0;

        int dayOneOriginalYearDays = dayOne.get(Calendar.DAY_OF_YEAR);

        while (dayOne.get(Calendar.YEAR) > dayTwo.get(Calendar.YEAR)) {
            dayOne.add(Calendar.YEAR, -1);            // 
            extraDays += dayOne.getActualMaximum(Calendar.DAY_OF_YEAR);
        }

        return extraDays - dayTwo.get(Calendar.DAY_OF_YEAR) + dayOneOriginalYearDays ;
	}

}

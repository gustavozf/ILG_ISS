package com.silverdev.ilg.general;

import java.util.Calendar;

public class Calendario {

    public String getMonthAndYear(){
        Calendar cal = Calendar.getInstance();
        int year, month;

        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) +1;

        return month + "/" + year;
    }

    public String getDayMonthYear(){
        Calendar cal = Calendar.getInstance();
        int day, year, month;

        day = cal.get(Calendar.DAY_OF_WEEK);
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) +1;

        return day + "/" + month + "/" + year;
    }
}

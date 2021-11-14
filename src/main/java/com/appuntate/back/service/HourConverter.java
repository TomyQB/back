package com.appuntate.back.service;

import org.springframework.stereotype.Service;

@Service
public class HourConverter {

    public static String hourToString(int hour) {
        String s = hour + "";
        String h = s.substring(0, 2);
        String m = s.substring(2);
        s = h + ":" + m;
        return s;
    }

    public static int stringToHour(String hour) {
        hour = hour.replace(":", "");
        return Integer.parseInt(hour);
    }

    public static String dateToHours(String date){
        int ini = date.indexOf("T");
        return date.substring(ini + 1, ini + 6);
    }

    public static String dateToDate(String date) {
        return date.substring(0, 10);
    }
    
}

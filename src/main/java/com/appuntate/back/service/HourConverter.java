package com.appuntate.back.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class HourConverter {

    public static String hourToString(int hour) {
        if(hour / 1000 == 0) return converterThreeDigit(hour);
        return converterFourDigit(hour);
    }

    private static String converterThreeDigit(int hour) {
        String s = hour + "";
        String h = s.substring(0, 1);
        String m = s.substring(1);
        s = "0" + h + ":" + m;
        return s;
    }
    
    private static String converterFourDigit(int hour) {
        String s = hour + "";
        String h = s.substring(0, 2);
        String m = s.substring(2);
        s = h + ":" + m;
        return s;
    }

    public static List<String> listHourToListString(List<Integer> hours) {
        List<String> strings = new ArrayList<>();

        for (Integer hour : hours) {
            String string = hourToString(hour);
            strings.add(string);
        }

        return strings;
    }

    public static String hourToDurationString(int hour) {
        String s = hour + "";
        String h = s.substring(0, 1);
        String m = s.substring(1);
        s = h + "h";
        if(!m.equals("00")) s += " " + m + "m";
        return s;
    }

    public static int stringToHour(String hour) {
        hour = hour.replace(":", "");
        return Integer.parseInt(hour);
    }

    public static String dateToStringHour(String date){
        int ini = date.indexOf("T");
        return date.substring(ini + 1, ini + 6);
    }
    
    public static int dateToHour(String date){
        return stringToHour(dateToStringHour(date));
    }

    public static String dateToDate(String date) {
        return date.substring(0, 10);
    }

    public static LocalDate stringToDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        return LocalDate.parse(date, formatter);
    }
    
}

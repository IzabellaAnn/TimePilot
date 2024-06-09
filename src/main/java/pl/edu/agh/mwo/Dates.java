package pl.edu.agh.mwo;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Dates {
    public static String todayDateString(){
        return LocalDate.now().toString();
    }

    public static String yesterdayDateString(){
        LocalDate yesterdayDate = LocalDate.now().minusDays(1);
        return yesterdayDate.toString();
    }

    public static String currentWeekStart(){
        LocalDate start = LocalDate.now();
        while (start.getDayOfWeek() != DayOfWeek.MONDAY) {
            start = start.minusDays(1);
        }
        return start.toString();
    }

    public static String currentWeekEnd(){
        return LocalDate.now().toString();
    }
    public static String lastWeekStart(){
        LocalDate start = LocalDate.now();
        if (start.getDayOfWeek() == DayOfWeek.MONDAY) {
            start = start.minusDays(7);
        }else{
            while (start.getDayOfWeek() != DayOfWeek.MONDAY) {
                start = start.minusDays(1);
            }
            start = start.minusDays(7);
        }
        return start.toString();
    }

    public static String lastWeekEnd(){
        LocalDate end = LocalDate.now();
        if (end.getDayOfWeek() == DayOfWeek.SUNDAY) {
            end = end.minusDays(7);
        }else{
            while (end.getDayOfWeek() != DayOfWeek.SUNDAY) {
                end = end.minusDays(1);
            }
            end = end.minusDays(7);
        }
        return end.toString();
    }



}

package model.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {


    public static LocalDate getDateFromString(String dataStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return LocalDate.parse(dataStr, formatter);
    }

    public static LocalTime getTimeFromString(String timeStr){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        return LocalTime.parse(timeStr,formatter);
    }
}

package model.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {


    public static LocalDate getDateFromString1(String dataStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return LocalDate.parse(dataStr, formatter);
    }

    public static LocalDate getDateFromString2(String dataStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dataStr);

        return LocalDate.parse(data.format(formatter), formatter);
    }

    public static LocalTime getTimeFromString(String timeStr){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        return LocalTime.parse(timeStr,formatter);
    }

    public static String getStringFromDate1(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }

    public static String getStringFromDate2(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    public static String getStringFromTime(LocalTime horario) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return horario.format(formatter);
    }

}

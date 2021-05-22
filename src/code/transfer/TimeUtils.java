package code.transfer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class TimeUtils {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public static String convertToString(LocalDate date) {
        return date.format(formatter);
    }

    public static LocalDate convertToDate(String date) {

        return LocalDate.parse(date, formatter);
    }


    public static Boolean checkFormat(String date){
        return Pattern.matches("\\d{4}-\\d{2}-\\d{2}",date);
    }
}

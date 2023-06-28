package utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateUtils {

    /**
     * Returns an English String of the day of week of a date. Return in the form of 'Monday', ect...
     * @param day Day
     * @param month Month
     * @param year Year
     * @return English String of the day of week.
     * @throws java.time.DateTimeException if the inputs is not a valid date.
     */
    public static String getDayOfWeek(int day, int month, int year) {
        return getDayOfWeek(LocalDate.of(year,month,day));
    }

    /**
     * Returns an English String of the day of week of a date. Return in the form of 'Monday', ect...
     * @param date The date to check
     * @return English String of the day of week.
     */
    public static String getDayOfWeek(LocalDate date){
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public static int getDaysBetween(LocalDate date1, LocalDate date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("Input dates cannot be null");
        }
        return Math.abs(date1.getDayOfYear() - date2.getDayOfYear());
    }

    public static boolean isLeapYear(int year) {
        return Year.isLeap(year);
    }

}

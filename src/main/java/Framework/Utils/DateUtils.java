package Framework.Utils;

import Framework.Logger;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtils {
    private static DateTime currentDate = new DateTime();

    public static String getCurrentDateString() {
        return currentDate.toString(DatePatterns.EEEE_MMMMMMMMM_d.getPattern(), Locale.UK);
    }

    public static String getCurrentDate(DatePatterns datePattern) {
        return currentDate.toString(datePattern.getPattern(), Locale.UK);
    }

    public static Date getCurrentDate() {
        GregorianCalendar now = new GregorianCalendar();
        return now.getTime();
    }

    public static Date parseDateFromString(String dateAsString, DatePatterns datePatterns) {
        Logger.info("Parsing date from string " + dateAsString + " with expected date pattern " + datePatterns.getPattern() + ".");
        try {
            return new SimpleDateFormat(datePatterns.getPattern()).parse(dateAsString);
        } catch (ParseException ignored) {
            throw new RuntimeException("Date could not be parsed.");
        }
    }

    public static String getDateInFuture(int days, DatePatterns pattern) {
        return currentDate.plusDays(days).toString(pattern.getPattern(), Locale.US);
    }

    public static String getDateInFuture(int days) {
        return getDateInFuture(days, DatePatterns.EEEE_MMMMMMMMM_d);
    }

    public static String getDateInPast(int days) {
        return getDateInPast(days, DatePatterns.EEEE_MMMMMMMMM_d);
    }

    public static String getDateInPast(int days, DatePatterns pattern) {
        return currentDate.minusDays(days).toString(pattern.getPattern(), Locale.US);
    }


}

package io.nextree.java.travelClub.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
    public static String today(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        return dateFormat.format(Calendar.getInstance().getTime());
    }
    public static String today() {
        return today("yyyy.MM.dd");
    }
}

package master.imd.ufrn.br.carusepattern.getbehavior.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {

    private static SimpleDateFormat sdf;

    public static String dateToString(Date date) {
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static Date stringToDate(String string) throws ParseException {
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(string);
    }

    public static String longToString(long input){
        Date date = new Date(input);
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static String usingDateFormatter(long input){
        Date date = new Date(input);
        return dateToString(date);
    }
}

package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * @author lirui
 **/
public class Test {
    public static void main(String [] args) {
        String dateStr = "2018-6-11 10:43:30.0";
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(simpleDateFormat.format(date));
    }
}

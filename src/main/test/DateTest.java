package main.test;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

/***
 * @author lirui
 **/
public class DateTest {

    /**
     * 功能描述: 将两个时间的差值转为时分秒
     *
     * @author : lirui
     * @date : 2019/6/11 16:44
     */
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        hourFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        Date start = dateFormat.parse("2019-6-10 23:20:00");
        Date end = dateFormat.parse("2019-06-11 1:00:00");
        Long time = end.getTime() - start.getTime();
        String timeStr = hourFormat.format(time);
        System.out.println(timeStr);
    }

    @Test
    public void localDataTimeTest() {
        // 默认格式yyyy-MM-ddTHH:mm:ss.sss
        LocalDateTime localDateTime = LocalDateTime.parse("2021-03-25T14:12:04.615");
        LocalDateTime now = LocalDateTime.now();
        if (localDateTime.isBefore(now)) {
            System.out.println("true");
        }
        // 2021-03-25T14:12:04.615
        System.out.println(localDateTime);
    }
}

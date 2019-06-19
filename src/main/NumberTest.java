package main;

/***
 * @author lirui
 **/
public class NumberTest {
    /**
     * 功能描述: long类型数据差值,取整,取余,计算分秒
     *
     * @author : lirui
     * @date : 2019/6/11 17:14
     */
    public static void main(String[] args) {
        long a = 123456L;
        long b = 353789L;
        long c = b - a;
        String minute = String.valueOf(c / 60000);
        String second = String.valueOf(c / 1000 % 60);
        System.out.println(minute + "  " + second);
    }
}

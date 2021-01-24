package main.test;

import org.junit.Test;
import java.util.Arrays;

/***
 * @author lirui
 **/
public class StringTest {
    /**
     * 功能描述: 在分隔符没有找到时,会将字符串放入数组的第一个位置,下标为0
     *
     * @author : lirui
     * @date : 2019/6/13 9:29
     */
    @Test
    public void splitTest() {
        String s = "1,23t,,est,,,,";
        String[] args = s.split(",");
        System.out.println(args[0]);
        for (String a : args) {
            System.out.println(a);
        }
    }

    @Test
    public void getByte() {
        System.out.println(Arrays.toString("123".getBytes()));
    }
}

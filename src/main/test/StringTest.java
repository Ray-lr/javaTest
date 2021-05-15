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
        // [97,65]
        System.out.println(Arrays.toString("aA".getBytes()));
    }

    @Test
    public void reverse() {
        char[] a = new char[]{'1', 'a', 'A', '=', ']'};
        int i = 0;
        while (i < a.length / 2) {
            int diff = a[i] - a[a.length - i - 1];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] += diff;
            i++;
        }
        System.out.println(a);
    }

    @Test
    public void substring() {
        System.out.println("12".substring(0, 1));
    }
}

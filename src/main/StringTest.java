package main;

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
    public static void main(String[] args) {
        String s = "123test";
        args = s.split(",");
        System.out.println(args[0]);
        for (String a : args) {
            System.out.println(a);
        }
    }
}

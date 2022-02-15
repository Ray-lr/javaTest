package main.test.question.chars;

/***
 *  @author : lirui
 *  @date :  2021/12/17
 *  @description : 第一个不重复的字符,返回下标
 *
 ***/
public class FirstUniqueChar {

    public static void main(String[] args) {
        String s = "stories";
        System.out.println(firstUniqueChar(s));
    }

    public static int firstUniqueChar(String s) {
        char[] chars = s.toCharArray();
        outer:
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < chars.length; j++) {
                if (i != j && chars[j] == chars[i]) {
                    continue outer;
                }
            }
            return i;
        }
        return -1;
    }
}

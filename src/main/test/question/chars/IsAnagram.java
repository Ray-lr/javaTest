package main.test.question.chars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 *  @author : lirui
 *  @date :  2021/12/22
 *  @description : 给定两个字符串,判断是否是字母异位词
 *      如果两个字符串中的所有字符的出现次数都一样,即为字母异位词
 *      例:
 *      输入: s = "anagram", t = "nagaram"
 *      输出: true
 ***/
public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram2("anagram", "nagaram"));
    }

    private static boolean isAnagram1(String s, String t) {
        int length = s.length();
        if (length != t.length()) {
            return false;
        }
        if (length < 2) {
            return s.equals(t);
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc, tc);
    }

    private static boolean isAnagram2(String s, String t) {
        int length = s.length();
        if (length != t.length()) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int key, value;
        for (int i = 0; i < length; i++) {
            key = sc[i];
            value = map.get(key) == null ? 0 : map.get(key);
            map.put(key, ++value);
            key = tc[i];
            value = map.get(key) == null ? 0 : map.get(key);
            map.put(key, --value);
        }
        return map.values().stream().filter(integer -> integer > 0).count() < 1;
    }
}

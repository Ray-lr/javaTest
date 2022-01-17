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
        // 长度判断
        if (length != t.length()) {
            return false;
        }
        // 只有一个字符,直接判断相等
        if (length < 2) {
            return s.equals(t);
        }
        // 转字符数组
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        // 排序
        Arrays.sort(sc);
        Arrays.sort(tc);
        // 判断数组相等
        return Arrays.equals(sc, tc);
    }

    private static boolean isAnagram2(String s, String t) {
        int length = s.length();
        if (length != t.length()) {
            return false;
        }
        // key是字符的ASCII码,value是该字符出现次数
        Map<Integer, Integer> map = new HashMap<>();
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int key, value;
        for (int i = 0; i < length; i++) {
            // 将s中的字符在map里的出现次数 + 1
            key = sc[i];
            value = map.get(key) == null ? 0 : map.get(key);
            map.put(key, ++value);
            // 将t中的字符在map里的出现次数 - 1
            key = tc[i];
            value = map.get(key) == null ? 0 : map.get(key);
            map.put(key, --value);
        }
        // 过滤加减不平衡的字符,即为单侧出现的字符
        return map.values().stream().filter(integer -> integer > 0).count() < 1;
    }

    public boolean isAnagram3(String s, String t) {
        int[] ints = new int[26];
        // s全部存到哈希表中
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int anInt = ints[t.charAt(i) - 'a']--;
            // 如果已经出现不一致的提前返回
            if (anInt < 0) {
                return false;
            }
        }
        // 遍历哈希表，不为0表示不一致
        for (int anInt : ints) {
            if (anInt != 0) {
                return false;
            }
        }
        return true;
    }
}

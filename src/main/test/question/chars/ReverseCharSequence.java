package main.test.question.chars;

/***
 *  @author : lirui
 *  @date :  2021/12/15
 *  @description : 翻转char数组
 *
 ***/
public class ReverseCharSequence {

    public static void reverseString1(char[] s) {
        int l = s.length;
        int difference;
        for (int i = 0; i < l / 2; i++) {
            difference = s[i] - s[l - 1 - i];
            s[i] -= difference;
            s[l - 1 - i] += difference;
        }
    }

    public static void reverseString2(char[] s) {
        int l = s.length;
        char temp;
        for (int i = 0; i < l / 2; i++) {
            temp = s[i];
            s[i] = s[l - 1 - i];
            s[l - 1 - i] = temp;
        }
    }

    // x^=y; y^=x; x^=y;就能把x和y互换
    public static void reverseString3(char[] s) {
        int l = s.length;
        for (int i = 0; i < l / 2; i++) {
            s[i] ^= s[l - 1 - i];
            s[l - 1 - i] ^= s[i];
            s[i] ^= s[l - 1 - i];
        }
    }

}

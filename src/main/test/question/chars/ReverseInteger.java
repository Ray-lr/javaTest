package main.test.question.chars;

/***
 *  @author : lirui
 *  @date :  2021/12/15
 *  @description : 反转整数
 *
 ***/
public class ReverseInteger {
    public static void main(String[] args) {
        long milliseconds = System.currentTimeMillis();
        System.out.println(reverse2(-1234567231));
        System.out.println(System.currentTimeMillis() - milliseconds);
    }

    public static int reverse1(int x) {
        if (x == 0) {
            return x;
        }
        boolean flag = false;
        // 如果为负数,先转正
        if (x < 0) {
            flag = true;
            x = -x;
        }
        // 转为字符数组
        String s = String.valueOf(x);
        char[] c = s.toCharArray();
        // 翻转
        reverseString(c);
        // 再转回字符串
        s = new String(c);
        try {
            // 转为int
            x = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            // 超过长度,置为零
            x = 0;
            e.printStackTrace();
        }
        // 原数为负的话,加负号再返回
        if (flag && x != 0) {
            x = -x;
        }
        return x;
    }

    public static void reverseString(char[] s) {
        int l = s.length;
        for (int i = 0; i < l / 2; i++) {
            s[i] ^= s[l - 1 - i];
            s[l - 1 - i] ^= s[i];
            s[i] ^= s[l - 1 - i];
        }
    }

    public static int reverse2(int x) {
        long res = 0;
        while (x != 0) {
            // 每次取最后一位,加上结果值的十倍
            res = res * 10 + x % 10;
            // 计算完,原值去掉最后一位
            x /= 10;
        }
        // 如果转为int不等于long类型,证明超出范围了,返回0
        return (int) res == res ? (int) res : 0;
    }
}

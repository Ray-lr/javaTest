package main.test.question;

import java.util.Scanner;

/***
 *@author : Ray
 *@date :  2021/1/28 18:52
 *description: the length of the max common substring between two strings
 ***/
public class MaxCommonSubStringTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        long before = System.currentTimeMillis();
        int count = 0;
        String less;
        String more;
        if (s1.length() > s2.length()) {
            less = s2;
            more = s1;
        } else {
            less = s1;
            more = s2;
        }
        for (int j = less.length(); j > 0; j--) {
            for (int i = 0; i <= less.length() - j; i++) {
                count++;
                if (more.contains(less.substring(i, i + j))) {
                    System.out.println("length: " + j);
                    System.out.println("loop times: " + count);
                    System.out.println("ms: " + (System.currentTimeMillis() - before));
                    return;
                }
            }


        }

    }
}

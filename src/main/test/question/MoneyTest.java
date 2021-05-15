package main.test.question;

import java.util.Scanner;

/***
 *@author : Ray
 *@date :  2021/1/28 17:36
 *description: how many ways to combine the money to the target (n)
 ***/
public class MoneyTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] money = {1, 5, 10, 20, 50, 100};
            long[] result = new long[n + 1];
            result[0] = 1;
            for (int aMoney : money) {
                for (int j = aMoney; j <= n; j++) {
                    result[j] += result[j - aMoney];
                }
            }
            System.out.println(result[n]);
        }
        sc.close();
    }
}

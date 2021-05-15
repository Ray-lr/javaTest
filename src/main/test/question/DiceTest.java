package main.test.question;

import java.util.Scanner;

/***
 *@author : Ray
 *@date :  2021/1/27 23:19
 *description: roll a dice, calculate how many situations on running n steps
 ***/
public class DiceTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(calculate(scanner.nextInt()));
    }

    private static int calculate(int n) {
        if (n < 1 || n > 6) {
            return 0;
        }
        int count = 0;
        if (n == 1) {
            count = 1;
        } else if (n == 2) {
            count = 2;
        } else {
            for (int i = 1; i < n; i++) {
                count += calculate(n - i);
            }
            count += 1;
        }
        return count;
    }
}

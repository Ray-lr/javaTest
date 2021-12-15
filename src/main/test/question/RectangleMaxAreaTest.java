package main.test.question;

import java.util.Scanner;

/***
 *@author : Ray
 *@date :  2021/1/28 18:33
 *description: max area of a given int array with width 1
 ***/
public class RectangleMaxAreaTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;
            while (left > 0 && array[left - 1] >= array[i]) {
                left--;
            }
            while (right < n - 1 && array[right + 1] >= array[i]) {
                right++;
            }
            int tempArea = (right - left + 1) * array[i];
            max = Math.max(max, tempArea);
        }
        System.out.println(max);
    }
}

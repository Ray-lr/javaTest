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
        // 每次都从中间往两边走
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;
            // 如果left的左边比left大,left往左移一步
            while (left > 0 && array[left - 1] >= array[i]) {
                left--;
            }
            // 如果right的右边比right大,right往左移一步
            while (right < n - 1 && array[right + 1] >= array[i]) {
                right++;
            }
            // 计算当前i下的最大面积
            int tempArea = (right - left + 1) * array[i];
            // 和以往的最大面积取最大值
            max = Math.max(max, tempArea);
        }
        System.out.println(max);
    }
}

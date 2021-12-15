package main.test.question.arrays;

import java.util.Arrays;

/***
 *  @author : lirui
 *  @date :  2021/10/28
 *  @description : 数组旋转
 *给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 ***/
public class ArrayRotating {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] nums = {-1, 2};
        rotate2(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate1(int[] nums, int k) {
        int length = nums.length;
        // 旋转数量超过长度无意义
        k = k % length;
        if (k >= 0) {
            // 临时数组复制原数组
            int[] temp = Arrays.copyOf(nums, nums.length);
            // 将length-k到length的数复制到nums里的0到K
            System.arraycopy(temp, length - k, nums, 0, k);
            // 再把0到length-k复制到nums里的k到length
            System.arraycopy(temp, 0, nums, k, length - k);
        }
    }

    public static void rotate2(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        if (k >= 0 && length - k >= 0) {
            int[] temp = new int[k];
            System.arraycopy(nums, length - k, temp, 0, k);
            System.arraycopy(nums, 0, nums, k, length - k);
            System.arraycopy(temp, 0, nums, 0, k);
        }
    }


}

package main.test.question.arrays;

/***
 *  @author : lirui
 *  @date :  2021/11/25
 *  @description : 给定int数组表示一个数的各个位数,返回加1后的数组
 *      eg. 给{1,2,3}
 *          返{1,2,4}
 ***/
public class PlusOne {

    public int[] plusOne1(int[] digits) {
        int length = digits.length;
        // 最后一位不为9,直接加1返回
        if (digits[length - 1] < 9) {
            digits[length - 1] = digits[length - 1] + 1;
            return digits;
        } else {
            // 循环向前找
            int i = length - 1;
            while (i >= 0 && digits[i] == 9) {
                // 为9就置为0
                digits[i] = 0;
                i--;
            }
            // 找到不为9的,加1返回
            if (i >= 0) {
                digits[i] += 1;
                return digits;
            } else {
                // 全部都是9,舍弃原数组,新数组为1后边length个0
                int[] result = new int[length + 1];
                result[0] = 1;
                return result;
            }
        }
    }

    public int[] plusOne2(int[] digits) {
        int length = digits.length;
        // 倒序遍历
        for (int i = length - 1; i >= 0; i--) {
            // 不为9就+1返回
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                // 为9就置为0
                digits[i] = 0;
            }
        }
        // 全是9,创建length+1的新数组,第一位为1,其余取默认值0
        int[] result = new int[length + 1];
        result[0] = 1;
        return result;
    }
}

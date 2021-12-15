package main.test.question.arrays;

/***
 *  @author : lirui
 *  @date :  2021/11/25
 *  @description :
 *  给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 ***/
public class MoveZeroes {

    public void moveZeroes1(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            // 找到为零的下标i
            if (nums[i] == 0) {
                // 从i开始往后,找到不为零的下标j
                for (int j = i + 1; j < length; j++) {
                    // 互换
                    if (nums[j] != 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int index = 0, length = nums.length;
        // 为0就向前覆盖
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        // 将index之后的数都置为0
        while (index < length) {
            nums[index++] = 0;
        }
    }

    public void moveZeroes3(int[] nums) {
        int j = 0, length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}

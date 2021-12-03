package main.test.question;

import java.util.HashMap;
import java.util.Map;

/***
 *  @author : lirui
 *  @date :  2021/11/25
 *  @description : 
 *  给定一个整数数组 nums和一个整数目标值 target，
 *  请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 ***/
public class TwoSum {

    public int[] twoSum1(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            int difference = target - nums[i];
            for (int j = i + 1; j < length; j++) {
                if (nums[j] == difference) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.get(target - nums[i]) != null) {
                return new int[]{m.get(target - nums[i]), i};
            }
            m.put(nums[i], i);
        }
        return new int[]{};
    }


}

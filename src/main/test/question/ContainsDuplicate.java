package main.test.question;

/***
 *  @author : lirui
 *  @date :  2021/11/3
 *  @description : 判断数组中是否有重复元素
 *
 ***/
public class ContainsDuplicate {

    public boolean containsDuplicateHash(int[] nums) {
        // 排除长度小于等于1
        int length = nums.length;
        if (length <= 1) {
            return false;
        }
        // 定义 hash 表
        int[] hashtable = new int[length];
        // 0 哈希值比较特殊
        int count0 = 0;
        // 循环存入hash表（除余hash算法）
        for (int i : nums) {
            // 0的个数
            if (i == 0) {
                count0++;
                if (count0 > 1) {
                    return true;
                }
                // 不存入hash表
                continue;
            }
            // 取余
            int remainder = i % length;
            // 余为负数处理
            if (remainder < 0) {
                remainder += length;
            }
            // hash 判断
            while (true) {
                // 判断该位置是否有数
                if (hashtable[remainder] == 0) {
                    // 无数则存入
                    hashtable[remainder] = i;
                    break;
                } else if (hashtable[remainder] == i) {
                    // 有数且相等,即为重复
                    return true;
                } else {
                    // 有数且不相等，存入后一位，以此类推
                    remainder++;
                    // 加完之后大于长度的处理
                    if (remainder >= length) {
                        remainder -= length;
                    }
                }
            }
        }
        return false;
    }
}

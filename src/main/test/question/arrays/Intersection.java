package main.test.question.arrays;

import java.util.*;

/***
 *  @author : lirui
 *  @date :  2021/11/16
 *  @description : 两个数组，取交集
 *
 ***/
public class Intersection {

    public static int[] intersection1(int[] nums1, int[] nums2) {
        // 两个map分别存两个数组内每个数的重复次数
        Map<Integer, Integer> map1 = transferToMap(nums1);
        Map<Integer, Integer> map2 = transferToMap(nums2);
        List<Integer> result = new ArrayList<>();
        // 遍历找到两个map都包含的key
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                // 取重复次数最小的作为循环次数
                int loop = Math.min(entry.getValue(), map2.get(entry.getKey()));
                // 循环存入结果集
                for (int i = 0; i < loop; i++) {
                    result.add(entry.getKey());
                }
            }
        }
        // 结果集list转为数组
        int[] re = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            re[i] = result.get(i);
        }
        return re;
    }

    private static Map<Integer, Integer> transferToMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        return map;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        // 先分别排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // 双指针
        int i = 0, j = 0;
        List<Integer> resultList = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            // 谁对应的值小,谁往后移动
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                // 相等时,加入结果集
                resultList.add(nums1[i]);
                i++;
                j++;
            }
        }
        // 结果集转为数组
        int[] re = new int[resultList.size()];
        for (int k = 0; k < resultList.size(); k++) {
            re[k] = resultList.get(k);
        }
        return re;
    }
}

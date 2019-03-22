package com.zhangze.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数组，一个数字，找到数组中的两个数，相加等于给定的数子，并输出数组的下角标
 * 例子：
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    // 穷举法，遍历所有
    // Time complexity O(n*n)
    // Space complexity O(1)
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0;i < nums.length;i++){
            for(int j = i+1;j < nums.length; j++) {
                if((nums[i] + nums[j]) == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    // 生成一个map，key是数组的值，value是值在数组的角标
    // 遍历数组，看map中有target-nums[i]的key
    private static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++) {
            map.put(nums[i], i);
        }
        for (int i = 0;i < nums.length;i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        return null;
    }

    // 原理同上，只是遍历一次
    private static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length ;i++) {
            map.put(nums[i], i);
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ar = twoSum3(new int[]{1,2,3,5,6}, 8);
        for (int i : ar){
            System.out.println(i);
        }
    }
}

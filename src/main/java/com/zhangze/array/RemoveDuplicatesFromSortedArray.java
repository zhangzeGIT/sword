package com.zhangze.array;

/**
 * Created by zhangze on 2019/8/8
 * 26、删除重复的从给定排序的集合，要求空间复杂度O(1)，并返回新的长度
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        if (nums.length == i) {
            return i;
        }
        i++;
        int j = nums[0];
        for (int num:nums) {
            if (j != num) {
                j = num;
                nums[i] = num;
                i++;
            }
        }
        return i;
    }
}

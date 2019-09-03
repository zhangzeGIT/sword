package com.zhangze.array;

import java.io.Serializable;

/**
 * Created by zhangze on 2019/9/2
 * 35、Search Insert Position
 *
 * 给定一个排序数组和一个目标值，返回这个值所在的角标位置，如果没有，返回这个值应该插入的位置
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums.length <= 0) {
            return 0;
        }
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {1};
        int a = SearchInsertPosition.class.newInstance().searchInsert(arr, 0);
        System.out.println(a);
    }
}

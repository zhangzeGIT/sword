package com.zhangze.array;

import java.util.*;

/**
 * Created by zhangze on 2019/6/5
 *
 * 18、 4Sum
 * 给定一个integer数组，找到所有四个数的集合，使四个数相加等于target
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 4) {
            return lists;
        }
        for (int i = 0;i < nums.length - 3;i++) {
            for (int j = i+1;j < nums.length - 2;j++) {
                int start = j+1;
                int end = nums.length-1;
                while (end > start) {
                    int result = nums[i] + nums[j] + nums[start] + nums[end];
                    if (result == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        lists.add(list);
                        while (end > j && nums[end] == nums[end-1]) {
                            end--;
                        }
                        while (start < nums.length - 2 && nums[start] == nums[start+1]){
                            start++;
                        }
                        start++;
                        end--;
                    }else if (result < target) {
                        while (start < nums.length - 2 && nums[start] == nums[start+1]){
                            start++;
                        }
                        start++;
                    }else {
                        while (end > j && nums[end] == nums[end-1]) {
                            end--;
                        }
                        end--;
                    }
                }
                while (j < nums.length - 2&&nums[j] == nums[j+1]) {
                    j++;
                }
            }
            while (i < nums.length - 3&&nums[i] == nums[i+1]) {
                i++;
            }
        }
        return lists;
    }

    public static void main(String[] args) throws Exception{
        int[] numbers = {1, 0, -1, 0, -2, 2};
        FourSum.class.newInstance().fourSum(numbers, 0);
    }
}

package com.zhangze.tow.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangze on 2019/5/23
 *
 * 15、3Sum
 *
 * 给定一个int[] ，从中找到三个数，使三个数相加等于0，找出所有的组合
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0;i < nums.length - 2;i++) {
            int first = nums[i];
            int start = i+1;
            int end = nums.length-1;
            while(end > start) {
                int result = first + nums[start] + nums[end];
                if (result < 0) {
                    start++;
                }else if (result > 0){
                    end--;
                }else {
                    lists.add(Arrays.asList(first,nums[start],nums[end]));
                    start++;
                    while (start < end && nums[start] == nums[start-1]) {
                        start++;
                    }
                    end--;
                    while (end > start && nums[end] == nums[end+1]) {
                        end--;
                    }
                }
            }
            while ((i < (nums.length-2)) && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return lists;
    }

    public static void main(String[] args)throws Exception {
        int[] nums = {-1,0,1,2,-1,-4};
        ThreeSum.class.newInstance().threeSum(nums);
    }
}

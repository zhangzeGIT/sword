package com.zhangze.divideAndConquer;

/**
 * Created by zhangze on 2019/9/20
 * 53、Maximum Subarray：最大和子数组
 * 给一个Integer集合，找到一个largest sum的子数组，并返回和
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6
 *
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int maxEnd = nums[0];
        for (int i = 1; i < nums.length;i++) {
            maxEnd = Math.max(maxEnd + nums[i], nums[i]);
            max = Math.max(max, maxEnd);
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) throws Exception{
        int[] arr = {3, -10 , 1,1,1,1,1};
        MaximumSubarray.class.newInstance().maxSubArray(arr);
    }
}

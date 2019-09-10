package com.zhangze.array;

/**
 * Created by zhangze on 2019/9/4
 * 41、First  Missing Positive
 *
 * 给定一个非排序数组，找到其中没有出现的最小的正整数
 *
 * Input: [1,2,0]
 * Output: 3
 *
 * Input: [3,4,-1,1]
 * Output: 2
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 *
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0;i < nums.length;i++) {
            int xx = nums[i];
            while (nums[i] <= nums.length && nums[i] > 0 && nums[nums[i] - 1] != nums[i] ) {
                int n = nums[i];
                nums[i] = nums[n-1];
                nums[n-1] = n;
            }
        }
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] != i+1) {
                System.out.println(i+1);
                return i+1;
            }
        }
        System.out.println(nums.length);
        return nums.length+1;
    }

    public static void main(String[] args) throws Exception{
        int[] arr = {7,2,2,2,-7,8,8,3,3,5,-1,18,-1,-3,-7,-9,8,1,4};
        FirstMissingPositive.class.newInstance().firstMissingPositive(arr);
    }

}

package com.zhangze.array;

/**
 * Created by zhangze on 2019/9/12
 * 45、Jump Game II
 *
 * 给一个非负整数列表，最初位于数组的第一个位置
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int i = 0;
        int length = nums.length;
        int nextJump;
        int maxJump;
        for (int m = 0; m < length; m++) {
            if (m + 1 >= length) {
                return i;
            }
            if (nums[m] + m >= length - 1) {
                return i+1;
            }
            maxJump = nums[m + 1];
            nextJump = m + 1;
            for (int j = m + 1; j <= nums[m] + m && j < length; j++) {
                if (nums[j] >= maxJump - (j - nextJump)) {
                    nextJump = j;
                    maxJump = nums[j];

                }
            }
            i++;
            m = nextJump - 1;
        }
        return i;
    }








    public static void main(String[] args) throws Exception {
        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        int i = JumpGameII.class.newInstance().jump(nums);
        System.out.println(i);
    }





}

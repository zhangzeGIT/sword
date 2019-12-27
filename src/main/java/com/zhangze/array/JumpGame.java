package com.zhangze.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangze on 2019/9/25
 * 55、Jump Game
 * 给定一个非负数的Integer数组，初始位置在第一个角标位置
 * 每一个数字代表你可以跳跃的最大长度
 * 判断你可否跳到最后
 *
 *Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 *
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {
    private Map<Integer, Boolean> map = new HashMap<>();
    public boolean canJump(int[] nums) {
        if (nums.length <= 0) {return false;}
        boolean c = can(nums, 0);
        System.out.println(c);
        return c;
    }
    private boolean can(int[] nums, int start) {
        int first = nums[start];
        if ((first + start) >= nums.length - 1) {
            map.put(start, true);
            return true;
        }
        boolean can = false;
        for (int i = start + 1; i < start + first + 1;i++) {
            if (map.get(i) != null) {
                can = map.get(i);
            } else if (first < nums[i] + i - start){
                can = can(nums, i);
            }
            if (can) {
                break;
            }
        }
        map.put(start, can);
        return can;
    }

    // solution 贪婪
    public boolean canJump1(int[] nums) {
        int lastPost = nums.length - 1;
        for (int i = nums.length - 1;i >= 0;i--) {
            if (i + nums[i] >= lastPost) {
                lastPost = i;
            }
        }
        return lastPost == 0;
    }
    // 动态规划，从下到上
    enum Index {
        GOOD, BAD, UNKNOWN
    }
    public boolean canJump2(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0;i < memo.length;i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        for (int i = nums.length - 2;i >= 0;i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;

    }
    // 动态规划：从下到上
    Index[] memo;
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD;
        }
        int furthesJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1;nextPosition < furthesJump;nextPosition++) {
            if (canJumpFromPosition(position, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
    }
    public boolean canJump3(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0;i < memo.length;i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }

    public static void main(String[] args) throws Exception{
        int[] arr = {3,2,1,1,4};
        JumpGame.class.newInstance().canJump(arr);
    }
}

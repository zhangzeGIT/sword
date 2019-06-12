package com.zhangze.tow.pointers;

import com.alibaba.fastjson.JSON;
import sun.nio.cs.ext.MacThai;

import java.util.*;

/**
 * Created by zhangze on 2019/5/23
 *
 * 16、3Sum Closest
 * 给定一个int数组，和一个目标数字，找出三个数字相加，最接近目标数字，只输出一个最接近的就可以
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        if (nums.length <= 3) {
            for (int i = 0;i < nums.length;i++) {
                result+=nums[i];
            }
            return result;
        }
        result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0;i < nums.length - 2;i++) {
            int first = nums[i];
            int start = i + 1;
            int end = nums.length -1;
            while (end > start) {
                int a = first + nums[start] + nums[end];
                if (Math.abs(result) > Math.abs(a - target)){
                    result = a - target;
                    if (a - target > 0) {
                        end--;
                    }else {
                        start++;
                    }
                }else {
                    if (a - target > 0) {
                        end--;
                    }else {
                        start++;
                    }
                }
            }
        }
        System.out.println(result + target);
        return result + target;
    }

    public static void main(String[] args) throws Exception{
        int[] a = {-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33};
        ThreeSumClosest.class.newInstance().threeSumClosest(a, 0);
    }
}

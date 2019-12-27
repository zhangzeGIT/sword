package com.zhangze.sword;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangze on 2019/11/11
 * 39、数组中出现次数超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalf {

    Map<Integer, Integer> map = new HashMap<>();

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length <= 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int half = array.length / 2;
        for (int a : array) {
            if (map.get(a) == null) {
                map.put(a, 1);
            }
            else {
                map.put(a, map.get(a) + 1);
                if (map.get(a) > half) {
                    return a;
                }
            }
        }
        return 0;
    }


    /**
     * sword的解决方案
     * 根据数组的特性，取第一个数，相等+1，不相等-1，当为零的时候，取当前数字，继续重复
     * 大于一半数字的必然是最后取的，最后取的数字可能不是大于一半的数字
     */
    public int MoreThanHalfNum_Solution1(int[] nums) {
        int majority = nums[0];
        for (int i = 1, cnt = 1; i < nums.length; i++) {
            cnt = nums[i] == majority ? cnt + 1 : cnt - 1;
            if (cnt == 0) {
                majority = nums[i];
                cnt = 1;
            }
        }
        int cnt = 0;
        for (int val : nums)
            if (val == majority)
                cnt++;
        return cnt > nums.length / 2 ? majority : 0;
    }







    public static void main(String[] args) {

    }

}

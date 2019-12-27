package com.zhangze.sword;

import java.util.ArrayList;

/**
 * Created by zhangze on 2019/12/5
 * 57、和为S的两个数字
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class SumIsX {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array.length <= 0) return res;
        int start = 0;
        int end = array.length - 1;
        int max = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while (end > start) {
            if (array[end] + array[start] == sum) {
                if (array[end] * array[start] < max) {
                    left = array[start];
                    right = array[end];
                    max = array[end] * array[start];
                }
                end--;
                start++;
            }
            if (array[end] + array[start] < sum) {
                start++;
            } else {
                end--;
            }
        }
        if (left + right == sum){
            res.add(left);
            res.add(right);
        }
        return res;
    }

}

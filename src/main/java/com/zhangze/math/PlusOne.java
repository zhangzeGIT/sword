package com.zhangze.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangze on 2019/10/17
 * 66、Plus One : 加一个数
 * 给定一个非空的数字数组，表示一个非负整数，加一个一
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits.length <= 0) {
            return digits;
        }
        int add = 1;
        int index = digits.length - 1;
        while (index >= 0 && add > 0) {
            int indexSum = digits[index] + add;
            if (indexSum == 10) {
                digits[index] = 0;
                index--;
            } else {
                digits[index] = indexSum;
                add = 0;
            }
        }
        if (add == 0) {
            return digits;
        } else {
            int[] arr = new int[digits.length + 1];
            arr[0] = add;
            for (int i = 0 ;i < digits.length;i++) {
                arr[i + 1] = digits[i];
            }
            return arr;
        }
    }


    public static void main(String[] args) throws Exception{
        int[] arr = {9,9,9,9};
        int[] ret = PlusOne.class.newInstance().plusOne(arr);
        System.out.println(ret);
    }

}

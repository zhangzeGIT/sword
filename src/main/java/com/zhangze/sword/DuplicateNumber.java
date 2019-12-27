package com.zhangze.sword;

import java.util.HashMap;

/**
 * 3、数组中重复的数字
 *
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字
 */
public class DuplicateNumber {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i < length;i++) {
            if (map.get(numbers[i]) == null) {
                map.put(numbers[i], 1);
            } else {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    /**
     * 因为数字是0到n-1，所以，如果不重复，排序之后，角标位置应该和数字相同
     */
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        for (int i = 0; i < length;i++) {
            if (i == numbers[i]) {
                continue;
            }
            if (numbers[i] == numbers[numbers[i]]) {
                duplication[0] = numbers[i];
                return true;
            }
            int tmp = numbers[numbers[i]];
            numbers[numbers[i]] = numbers[i];
            numbers[i] = tmp;
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        int[] numbers = {2,1,3,1,4};
        DuplicateNumber.class.newInstance().duplicate1(numbers, 5, new int[1]);
    }
}

package com.zhangze.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangze on 2019/9/17
 * 47、PermutationsII
 * 给一个有明显特征的数组，返回所有可能的不重复的数列
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        if (nums.length <= 0) return rs;
        List<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        rs.add(first);
        for (int k = 1;k < nums.length;k++) {
            List<List<Integer>> new_rs = new ArrayList<>();
            int length = rs.size();
            for (int i = 0;i < length;i++) {
                List<Integer> current = rs.get(i);
                for (int j = 0; j <= current.size();j++) {
                    List<Integer> sencond = new ArrayList<>(current);
                    // 如果要插入的数字在当前列表中最后的index位置大于等于想要插入的位置
                    // 则忽略
                    if (sencond.lastIndexOf(nums[k]) >= j) {
                        continue;
                    }
                    sencond.add(j, nums[k]);
                    new_rs.add(sencond);
                }
            }
            rs.clear();
            rs = new_rs;
        }
        return rs;
    }


    public static void main(String[] args) throws Exception{
        int[] arr = {2,2,1,1};
        PermutationsII.class.newInstance().permuteUnique(arr);
    }
}

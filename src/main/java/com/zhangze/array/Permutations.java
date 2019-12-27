package com.zhangze.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangze on 2019/9/16
 * 46、Permutations：数列
 * 给一个有明显特征的数组，返回所有可能的数列
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class Permutations {
    /**
     * 基本思想是：以1，2，3为例
     * 第一次循环[1]
     * 第二次循环[1,2],[2,1]：将2分别插入到0,1位置
     * 第三次循环[3,1,2][1,3,2][1,2,3]...：将3分别插入到0,1,2的位置
     */
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        result.add(new ArrayList<>());
        for (int n : nums) {
            int size = result.size();
            for (;size > 0;size--) {
                List<Integer> r = result.pollFirst();
                for (int i = 0; i <= r.size(); i++) {
                    List<Integer> t = new ArrayList<>(r);
                    t.add(i, n);
                    result.add(t);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0) return ans;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        ans.add(list);
        for (int i = 1; i < nums.length; ++i) {
            List<List<Integer>> new_ans = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                for (List<Integer> l : ans) {
                    List<Integer> new_1 = new ArrayList<>(l);
                    new_1.add(j, nums[i]);
                    new_ans.add(new_1);
                }
            }
            ans = new_ans;
        }
        return ans;
    }



    public static void main(String[] args) throws Exception{
        int[] arr = {1,2,3,4};
        Permutations.class.newInstance().permute(arr);
    }
}

package com.zhangze.array;

import java.util.*;

/**
 * Created by zhangze on 2019/9/3
 * 39、Combination sum
 * 给定一个数组和一个目标值，找出数组中，累加和等于目标值的所有组合
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combination(candidates, target, 0);
    }

    public List<List<Integer>> combination(int[] candidates, int target, int start) {
        if (candidates.length <= 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start;i < candidates.length;i++) {
            List<Integer> list = new ArrayList<>();
            list.add(candidates[i]);
            if (target == candidates[i]) {
                result.add(list);
                continue;
            }
            if (target - candidates[i] > 0) {
                List<List<Integer>> r = combination(candidates, target - candidates[i], i);
                if (r.size() > 0) {
                    for (List<Integer> ii : r) {
                        ii.addAll(list);
                        result.add(ii);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        int[] arr = {2,5,2,1,2};
        List<List<Integer>> result = CombinationSum.class.newInstance().combinationSum(arr, 5);
        result.forEach(x -> x.forEach(System.out::println));
    }
}

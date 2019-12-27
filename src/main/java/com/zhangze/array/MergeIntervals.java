package com.zhangze.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangze on 2019/9/25
 * 56、Merge Intervals：合并区间
 * 给出一个区间集合，请合并所有重叠的区间
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> res = new ArrayList<>();
        if (intervals.length <= 0) {
            return new int[0][0];
        }

        // 先排序
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = 1;j < intervals.length; j++) {
                if (intervals[j-1][0] > intervals[j][0]) {
                    int[] a = intervals[j-1];
                    intervals[j-1] = intervals[j];
                    intervals[j] = a;
                }
            }
        }
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1;i < intervals.length;i++) {
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(left);
                list.add(right);
                res.add(list);
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(left);
        list.add(right);
        res.add(list);
        int[][] r = new int[res.size()][2];
        for (int i = 0;i < res.size();i++) {
            r[i][0] = res.get(i).get(0);
            r[i][1] = res.get(i).get(1);
        }
        Arrays.stream(r).forEach(System.out::println);
        return r;
    }

    // solution





    public static void main(String[] args) throws Exception{
        int[][] arr = {{1,3},{2,6},{8,10},{1,10}};
        MergeIntervals.class.newInstance().merge(arr);
    }










}

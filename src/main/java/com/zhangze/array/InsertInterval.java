package com.zhangze.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangze on 2019/9/26
 * 57、Insert Interval：插入间隔
 * 给定一个没有重合区间的set，插入一个新的区间，如果需要合并，请合并
 * 假设给定的区间是排好序的
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> res = new ArrayList<>();
        if (intervals.length <= 0 && newInterval.length <= 0) {
            return new int[0][0];
        }
        if (newInterval.length <= 0) {
            return intervals;
        }
         if (intervals.length <= 0) {
             int[][] re = new int[1][2];
             re[0][0] = newInterval[0];
             re[0][1] = newInterval[1];
             return re;
         }
         if (newInterval[1] < intervals[0][0]) {
             List<Integer> list = new ArrayList<>();
             list.add(newInterval[0]);
             list.add(newInterval[1]);
             res.add(list);
         }

        for (int i = 0;i < intervals.length;i++) {
             int left = intervals[i][0];
             int right = intervals[i][1];
             boolean flag = false;
             while(i < intervals.length && ((intervals[i][0] <= newInterval[0] && intervals[i][1] >= newInterval[0])
                     || (intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[1])
                     || (intervals[i][0] >= newInterval[0]) && intervals[i][1] <=newInterval[1])) {
                 right = intervals[i][1];
                 left = Math.min(left, newInterval[0]);
                 right = Math.max(right, newInterval[1]);
                 i++;
                 flag = true;
             }
             if (flag) {
                 i--;
             }
             List<Integer> list = new ArrayList<>();
             list.add(left);
             list.add(right);
             res.add(list);
             if (i + 1 < intervals.length && newInterval[0] > right && newInterval[1] < intervals[i+1][0]) {
                 List<Integer> list11 = new ArrayList<>();
                 list11.add(newInterval[0]);
                 list11.add(newInterval[1]);
                 res.add(list11);
             }
         }
        if (newInterval[0] > intervals[intervals.length - 1][1]) {
            List<Integer> list = new ArrayList<>();
            list.add(newInterval[0]);
            list.add(newInterval[1]);
            res.add(list);
        }
         int[][] r = new int[res.size()][2];
         for (int i = 0;i < res.size();i++) {
             r[i][0] = res.get(i).get(0);
             r[i][1] = res.get(i).get(1);
         }
         return r;
    }





    public static void main(String[] args) throws Exception{
        int[][] arr = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] a = {4,8};
        InsertInterval.class.newInstance().insert(arr, a);
    }
}

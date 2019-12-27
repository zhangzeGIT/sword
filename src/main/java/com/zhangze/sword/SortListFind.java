package com.zhangze.sword;

/**
 * Created by zhangze on 2019/11/26
 * 53、数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数
 */
public class SortListFind {


    /**
     * 也可以分两次递归，分别找到开头的K和结尾的K
     */
    public int GetNumberOfK(int [] array , int k) {
        if (array.length <= 0) return 0;
        int start = 0;
        int end = array.length - 1;
        int count = 0;
        while (end >= start) {
            int mid = (start + end) / 2;
            if (array[mid] == k) {
                int begin = mid - 1;
                int over = mid + 1;
                count++;
                while (begin >=0 && array[begin] == k) {
                    count++;
                    begin--;
                }
                while (over <= end && array[over] == k) {
                    count++;
                    over++;
                }
                return count;
            }
            if (array[mid] > k) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return count;
    }







    public static void main(String[] args) {


    }

}

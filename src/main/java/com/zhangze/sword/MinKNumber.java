package com.zhangze.sword;

import java.util.ArrayList;

/**
 * Created by zhangze on 2019/11/11
 * 40、最小的K个数
 *
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
 */
public class MinKNumber {


    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (k >= input.length || k <= 0) {
            return res;
        }
        quickSort(input, 0, input.length - 1);
        for (int i = 0; i < k;i++) {
            res.add(input[i]);
        }
        return res;
    }

    private void quickSort(int[] arr, int start, int end) {
        if (end<= start) return;
        int last = arr[end];
        int index = start;
        for (int i = start;i < end;i++) {
            if (arr[i] < last) {
                int a = arr[index];
                arr[index] = arr[i];
                arr[i] = a;
                index++;
            }
        }
        int a = arr[index];
        arr[index] = last;
        arr[end] = a;
        quickSort(arr, start, index - 1);
        quickSort(arr, index + 1, end);
    }
    private void sort(int[] arr) {
        if (arr.length <= 0) return;
        quickSort(arr, 0, arr.length - 1);
    }





    public static void main(String[] args) throws Exception{
        int[] arr = {4,5,1,6,2,7,3,8};
        MinKNumber.class.newInstance().GetLeastNumbers_Solution(arr, 8);
    }






}

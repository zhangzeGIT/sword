package com.zhangze;


import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class test {

    public static void main(String[] args) throws Exception{
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(2);
    }


    public static void quickSort(int[] arr, int start, int end) {
        if (end > start) {
            int mid = sort(arr, start, end);
            quickSort(arr, start, mid - 1);
            quickSort(arr, mid + 1, end);
        }
    }

    public static int sort(int[] arr, int start, int end) {
        int last = arr[end];
        int index = start - 1;
        for (int i = start;i < end;i++) {
            if (arr[i] < last) {
                index++;
                int tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
            }
        }
        int tmp = arr[index + 1];
        arr[index + 1] = last;
        arr[end] = tmp;
        return index + 1;
    }



}




























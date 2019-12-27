package com.zhangze.sword;

/**
 * Created by zhangze on 2019/11/6
 * 21、调整数组顺序，使奇数位于偶数前面
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class AdjustArrayOrder {

    public void reOrderArray(int [] array) {
        if (array.length <= 0) return;
        int start = 0;
        int end = array.length -1;
        while (end > start) {
            if (array[end] % 2 == 0) {
                end--;
                continue;
            }
            if (array[start] % 2 == 1) {
                start++;
                continue;
            }
            int a = array[start];
            array[start] = array[end];
            array[end] = a;
        }
    }

    public void reOrderArrays(int[] array) {
        if (array.length <= 0) return;
        int start = 0;
        int end = array.length;
        for (int i = start;i < end;i++) {
            if (array[i] % 2 == 0) {
                int index = array[i];
                for (int j = i;j < array.length - 1;j++) {
                    array[j] = array[j+1];
                }
                array[array.length - 1] = index;
                end--;
                i--;
            }
        }
    }













    public static void main(String[] args) throws Exception{
        int[] arr = {2,4,6,1,3,5,7};
        AdjustArrayOrder.class.newInstance().reOrderArrays(arr);
        for (int a : arr) {
            System.out.print(a);
        }

    }

}

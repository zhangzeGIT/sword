package com.zhangze.sword;

/**
 * Created by zhangze on 2019/11/29
 * 56、数组中数字出现的次数
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
 * 要求时间复杂度O(n),空间复杂度O(1)
 */
public class TheNumberOfTimesInArray {

    /**
     * num1,num2分别为长度为1的数组。传出参数
     * 将num1[0],num2[0]设置为返回结果
     *
     * 原理：任何数字异或自己都是零
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array.length <= 0) return;
        int and = 1;
        while (num1[0] == 0 || num2[0] == 0) {
            num1[0] = 0;
            num2[0] = 0;
            for (int i = 0 ;i < array.length;i++) {
                if ((array[i] & and) == 0) {
                    num1[0] = num1[0] ^ array[i];
                } else {
                    num2[0] = num2[0] ^ array[i];
                }
            }
            if (num1[0] != 0) {
                int x = num1[0];
                while ((x >> 1) != 0) {
                    x = x >> 1;
                    and = and << 1;
                }
            } else {
                int x = num1[1];
                while ((x >> 1) != 0) {
                    x = x >> 1;
                    and = and << 1;
                }
            }
        }

    }







    public static void main(String[] args) throws Exception{

        System.out.println(8 & 1);
        System.out.println(7 & 1);
        int[] arr = {2,3,6,6,8,2,3,7};
        TheNumberOfTimesInArray.class.newInstance().FindNumsAppearOnce(arr, new int[1], new int[1]);
    }

}

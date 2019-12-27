package com.zhangze.sword;

/**
 * 10、斐波那契数列
 */
public class Fibonacci {

    public int sulution(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int first = 0;
        int second = 1;
        int i = 2;
        int result = 0;
        while (i <= n) {
            result = first + second;
            first = second;
            second = result;
            i++;
        }
        return result;
    }



}

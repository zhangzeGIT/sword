package com.zhangze.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangze on 2019/8/16
 *
 * 29、divide two Integers
 * 在不适用乘法，除法和余运算符情况下对两个整数进行除法
 *
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 *
 *
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE) return dividend == Integer.MIN_VALUE? 1: 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;
        if (divisor == 2) return dividend >> 1;
        if (divisor == -2) return -dividend >> 1;

        boolean negative = (dividend ^ divisor) < 0;

        int result = 0;
        if (dividend == Integer.MIN_VALUE) {
            dividend += Math.abs(divisor);
            result = 1;
        }
        result += dividePositive2(Math.abs(dividend), Math.abs(divisor));
        return negative ? -result: result;
    }

    private int dividePositive(int dividend, int divisor) {
        int result = 0;
        while (dividend >= divisor) {
            int tmp = divisor;
            int count = 1;
            while (tmp + tmp < dividend && tmp + tmp > 0) {
                tmp += tmp;
                count += count;
            }
            dividend -= tmp;
            result += count;
        }
        return result;
    }

    private int dividePositive2(int dividend, int divisor) {
        int result = 0;
        while (dividend >= divisor) {
            int temp = divisor;
            int count = 1;
            while (temp + temp > 0 && dividend > (temp + temp)) {
                temp = temp + temp;
                count = count + count;
            }
            dividend = dividend - temp;
            result = result + count;
        }
        return result;
    }




    public static void main(String[] args)  throws Exception{
        int result = DivideTwoIntegers.class.newInstance().divide(-2147483648, -3);
        System.out.println(result);
    }
}

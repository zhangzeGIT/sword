package com.zhangze.math;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangze on 2019/9/20
 * 50、Pow(x, n)
 *
 * 得到x的n次方
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
public class Pow {
    public double myPow(double x, int n) {
        boolean nFu = n < 0;
        if (nFu) {
            n = -n;
        }
        double result = math(x, n);
        if (nFu) {
            result = 1/result;
        }
        System.out.println(result);
        return result;
    }
    public double math(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        } else {
            double re = math(x, n/2);
            if (n % 2 == 0) {
                return re * re;
            } else {
                return re * re * x;
            }
        }
    }

    // Discuss上的解发:位运算，会快点
    public double myPow2(double x, int n) {
        long m = n > 0 ? n :-(long)n;
        double ans = 1.0;
        while (m != 0) {
            if ((m & 1) == 1) {
                ans = ans * x;
            }
            x = x * x;
            m = m >> 1;
        }
        return n >= 0?ans : 1/ans;
    }

    public static void main(String[] args) throws Exception{
        double hh = Pow.class.newInstance().myPow2(2.0,-2);
        System.out.println(hh);
    }
}

package com.zhangze.sword;

/**
 * 16、数值的整数次方
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 *
 */
public class NumberPower {
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        if (exponent < 0) {
            base = 1 / base;
            exponent = exponent * -1;
        }
        return Power(base, exponent / 2) * Power(base, exponent / 2)  * (exponent % 2 == 0 ? 1 : base);
    }


    public static void main(String[] args) throws Exception{
        double d = NumberPower.class.newInstance().Power(2, -3);
        System.out.println(d);
    }
}

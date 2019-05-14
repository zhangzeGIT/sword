package com.zhangze.math;

/**
 * Created by zhangze on 2019/4/23
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1
 *  Input : 123
 *  Output: 321
 */
public class ReverseInteger {
    public int reverse(int x) {
        boolean isPositive = false;
        if(x < 0) {
            isPositive = true;
            x = x * -1;
        }

        if (x == 0) {return 0;}
        int result = 0;
        int i = 0;
        while (x > 0) {
            int left = x % 10;
            result = result*(int)Math.pow(10,i) + left;
            x = x - left;
            x = x / 10;
            i = 1;
        }
        if (isPositive) {
            return -1 * result;
        }else {
            return result;
        }
    }

    public static void main(String[] args) {
        // 1056389759
        System.out.println(new ReverseInteger().reverse(1534236469));
        System.out.println(-21521313/10);
        System.out.println(Integer.MIN_VALUE);
    }

    public int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public int reverse2(int x) {
        int result = 0;
        while(x != 0) {
            int right = x % 10;
            x = x /10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE/10&&right > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE/10 && right >8)) return 0;
            result = result * 10 + right;
        }
        return result;
    }
}

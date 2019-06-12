package com.zhangze.math;

/**
 * Created by zhangze on 2019/5/14
 *
 * 判断一个int是否是回文结构，从后往前读和从前往后读是一个数
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int result1 = x;
        int result = 0;
        while (x > 0) {
            int right = x % 10;
            result = result * 10 + right;
            x = x / 10;
        }
        if (result == result1 ) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        boolean a = palindromeNumber.isPalindrome(121);
        System.out.println(a);
    }
}

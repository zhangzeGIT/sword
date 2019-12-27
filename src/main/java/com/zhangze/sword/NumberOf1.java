package com.zhangze.sword;

/**
 * 15、二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {


    public int numberOf(int n) {
        int i = 0;
        for (int j = 0;j < 32;j++) {
            if ((n & 1) == 1) {
                i++;
            }
            n = n >> 1;
        }
        return i;
    }

    // leetcode上的解发
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            // 将n的二进制中的最右边的一个1变为0
            n &= (n - 1);
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception{
        int a = NumberOf1.class.newInstance().numberOf(10);
        System.out.println(a);
        System.out.println(0.05+0.01 == 0.06);
        System.out.println(0.060000000000000005 == 0.06);
        System.out.println(2.4);
    }

}

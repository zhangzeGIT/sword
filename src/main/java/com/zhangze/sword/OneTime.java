package com.zhangze.sword;

/**
 * Created by zhangze on 2019/11/12
 * 42、从1到n整数中1出现的次数
 *
 */
public class OneTime {


    public int NumberOf1Between1AndN_Solution(int n) {
        int all = 0;
        if (n <= 0) return all;
        for (int i = 1;i <= n;i++) {
            int a = i;
            while (a != 0) {
                if (a % 10 == 1) {
                    all++;
                }
                a = (a - a % 10 ) / 10;
            }
        }
        return all;
    }


    public static void main(String[] args) throws Exception{
        System.out.println(OneTime.class.newInstance().NumberOf1Between1AndN_Solution(12));
    }







}

package com.zhangze.string;

/**
 * Created by zhangze on 2019/4/29
 *
 * 问题8：将字符串转换成number
 *
 * 字符串开头可能是空格，如果去掉空格，开头的是字母之类的，就返回零
 * 字符串可能含有特殊字符
 * 超过最大最小int，返回最大的int和最小的int
 *
 * example：
 * Input: "words and 987"
 * Output: 0
 *
 * Input: "    4193 with words"
 * Output: 4193
 */
public class StringToInt {
    public static int myAtoi(String str) {
        char[] arr = str.toCharArray();
        if (arr.length == 0) {
            return 0;
        }
        boolean flag = false;
        int x = 0;
        boolean flag1 = true;
        int result = 0;
        for (int i = 0;i<arr.length;i++) {
            if (arr[i] == ' '){
                if (flag1){
                    continue;
                }else {
                    break;
                }
            }
            if (x > 1) {return 0;}
            if (arr[i] == '-' && result == 0) {
                if (!flag1) break;
                flag1=false;
                flag = true;
                x++;
                continue;
            }
            if (arr[i] == '+' && result == 0) {
                if (!flag1) break;
                flag1=false;
                x++;
                continue;
            }
            if (arr[i] >= '0' && arr[i] <= '9') {
                flag1=false;
                int a = arr[i]-'0';
                // 如果是负数
                if (flag) {
                    a = -1 * a;
                }

                if (flag) {
                    if (result < Integer.MIN_VALUE/10 || ( result == (Integer.MIN_VALUE/10) && a <= (Integer.MIN_VALUE  % 10)))
                        return Integer.MIN_VALUE;
                }else {
                    if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && a >= Integer.MAX_VALUE %10))
                        return Integer.MAX_VALUE;
                }
                result = result * 10 + a;
            }else {
                break;
            }
        }
        if (flag){
            return result;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "-91283472332";
        int a = myAtoi(s);
        System.out.println(a);
//        System.out.println(Integer.MIN_VALUE%10);
    }
}

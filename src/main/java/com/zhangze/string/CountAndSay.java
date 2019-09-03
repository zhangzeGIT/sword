package com.zhangze.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangze on 2019/9/3
 * 38、Count And Say
 * 给定一个整形数字，统计0-9的数字有集合，并返回字符串
 *
 * 1.     1
 * 2.     11
 * 3.     21
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            StringBuilder sb = new StringBuilder();
            String pre = countAndSay(n-1);
            int index = 0;
            int number = (int) pre.charAt(0) - '0';
            for (int i = 1;i < pre.length();i++) {
                if (number != (int) pre.charAt(i) - '0') {
                    sb.append(i-index).append(number);
                    number = (int) pre.charAt(i) - '0';
                    index = i;
                }
            }
            sb.append(pre.length() - index).append(number);
            return sb.toString();
        }
    }


    public static void main(String[] args) throws Exception {
        System.out.println(CountAndSay.class.newInstance().countAndSay(5));
    }
}

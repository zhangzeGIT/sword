package com.zhangze.sword;

/**
 * Created by zhangze on 2019/11/15
 * 46、把数字翻译成字符串
 *
 * 给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。一个数字有多种翻译可能，
 * 例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。实现一个函数，用来计算一个数字有多少种不同的翻译方法
 *
 */
public class IntegerToString {




    // 12345
    public int numDecodings(String s) {
        int[] arr = new int[s.length()];
        if (s.length() <= 0) return 0;
        arr[0] = 1;
        for (int i = 1;i < s.length();i++) {
            int pre = s.charAt(i-1) - '0';
            int current = s.charAt(i) - '0';
            if ((pre * 10 + current) > 26) {
                arr[i] = arr[i-1];
            } else {
                if (i - 2 > 0) {
                    arr[i] = arr[i-2] + arr[i-1];
                } else {
                    arr[i] = arr[i-1] + 1;
                }
            }
        }
        System.out.println(arr[s.length() - 1]);
        return arr[s.length()-1];
    }


    public static void main(String[] args) throws Exception{
        IntegerToString.class.newInstance().numDecodings("12258");
    }













}

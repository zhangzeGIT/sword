package com.zhangze.string;

import java.util.Stack;

/**
 * 题目五
 * 找出一个字符串的最大回文结构的子字符串
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 * 可以使用动态规划
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        if (arr.length == 0) {
            return "";
        }
        if (arr.length == 1) {
            return s;
        }
        StringBuilder sb;
        String result = String.valueOf(arr[0]);
        for (int i = 0;i < arr.length - 1;i++) {
            sb = new StringBuilder();
            sb.append(arr[i]);
            for (int j = i+1;j < arr.length;j++) {
                if (arr[j] == arr[i]) {
                    sb.append(arr[j]);
                    if (judgeHuiwen(sb.toString())){
                        if (result.length() < sb.length()) {
                            result = sb.toString();
                        }
                    }
                }else {
                    sb.append(arr[j]);
                }
            }
        }
        return result;
    }
    private boolean judgeHuiwen(String msg) {
        char[] arr = msg.toCharArray();
        for (int i = 0;i < arr.length/2;i++) {
            if (arr[i] != arr[arr.length-1-i]){
                return false;
            }
        }
        return true;
    }

    // 动态规划
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0,end = 0;
        for (int i = 0;i < s.length();i++) {
            int len1 = expandAroundCenter(s, i , i);
            int len2 = expandAroundCenter(s, i , i+1);
            int len = Math.max(len1,len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int l = left;
        int r = right;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        String s = "bb";
        new LongestPalindromicSubstring().longestPalindrome1(s);
    }
}

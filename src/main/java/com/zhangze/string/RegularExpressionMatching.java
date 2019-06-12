package com.zhangze.string;

/**
 * Created by zhangze on 2019/5/16
 *
 * 10。regular expression matching
 * 给一个string s，和一个正则string p
 * 看s能否匹配p
 *
 * . 可以匹配任意一个字符
 * * 可以匹配零个或多个前序字符
 *
 * example：
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * ".*" means "zero or more (*) of any character (.)".
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 */
public class RegularExpressionMatching {
    // 第一种方式，迭代遍历，将 "字母*" 看做一个整体
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();

        boolean first_match = (!s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) ||
                    (first_match && isMatch(s.substring(1),p)));
        }else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }

    }
    // 动态规划
    public static boolean isMatchDynamicProgramming(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                // 不是test的最后一位，并且与pattern匹配上，为true
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                // 如果不是pattern的最后一位并且pattern的后一位是*
                //
                if (j + 1 <pattern.length() && pattern.charAt(j + 1) == '*'){
                    // pattern后移两位(*匹配零个字符串的情况)，或者  text后移一位(*匹配多个字符串的情况)
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                }else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
    boolean[][] memo;
    public boolean isMatchDynamicProgrammingTopDownVariation(int i, int j, String text, String pattern) {
        memo[i][j] = true;
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        }else {
            boolean first_match = (i < text.length()&&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));
            if (j + 1 <pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (isMatchDynamicProgrammingTopDownVariation(i, j+2, text, pattern) ||
                        first_match && isMatchDynamicProgrammingTopDownVariation(i+1, j, text, pattern));
            }else {
                ans = first_match && isMatchDynamicProgrammingTopDownVariation(i+1,j+1,text,pattern);
            }
        }
        memo[i][j] = ans;
        return ans;
    }
    public boolean isTure(String text, String pattern) {
        memo = new boolean[text.length() + 1][pattern.length() + 1];
        return isMatchDynamicProgrammingTopDownVariation(0,0,text,pattern);
    }

    public static void main(String[] args) {
        RegularExpressionMatching matching = new RegularExpressionMatching();
        System.out.println(matching.isMatchDynamicProgramming("abbbc","ab*c"));
    }
}

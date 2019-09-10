package com.zhangze.string;

/**
 * Created by zhangze on 2019/9/10
 * 44、Wildcard Matching : 通配符匹配
 * 给定一个输入字符串S和一个匹配字符串P，通配符可以匹配‘？’和‘*’
 *
 * '?':可以匹配任意一个字符
 * '*':可以匹配任意字符序列，包含空串
 *
 * 例子：
 * s = "aa"
 * p = "a"
 * Output: false
 *
 * s = "aa"
 * p = "*"
 * Output: true
 *
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 *
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        char[] ws = s.toCharArray();
        char[] wp = p.toCharArray();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1;j <=n;j++) {
            dp[0][j] = dp[0][j-1] && wp[j-1] == '*';
        }
        for (int i = 1;i <= m;i++) {
            dp[i][0] = false;
        }
        for (int i = 1;i <=m;i++) {
            for (int j = 1;j <= n; j++) {
                if (wp[j-i] == '?' || ws[i-1] == wp[j-1])
                    dp[i][j] = dp[i-1][j-1];
                else if (wp[j-1] == '*')
                    dp[i][j] = dp[i-1][j] || dp[i][j];
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) throws Exception{
        boolean is = WildcardMatching.class.newInstance().isMatch("abbbba", "a**a*?");
        System.out.println(is);
    }













}

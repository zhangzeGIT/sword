package com.zhangze.sword;

/**
 * 19、正则表达式匹配 ---------------
 *
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class RegexMatch {

    public boolean match(char[] str, char[] pattern) {
        boolean[][] isTrue = new boolean[str.length + 1][pattern.length + 1];
        isTrue[0][0] = true;
        for (int i = 0; i < pattern.length;i++) {
            if (pattern[i] == '*') {
                isTrue[0][i+1] = isTrue[0][i-1];
            } else {
                isTrue[0][i+1] = false;
            }
        }
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (str[i] == pattern[j] || pattern[j] == '.') {
                    isTrue[i +1][j + 1] = isTrue[i][j];
                } else if (pattern[j] == '*') {
                    if (str[i] == pattern[j - 1] || pattern[j-1] == '.') {
                        isTrue[i+1][j+1] = isTrue[i+1][j] //一次
                                || isTrue[i][j+1] // 多次
                                || isTrue[i+1][j - 1]; // 空
                    } else {
                        isTrue[i+1][j+1] = isTrue[i+1][j-1];
                    }
                }
            }
        }
        return isTrue[str.length][pattern.length];
//        return matchOver(str, pattern, 0, 0);
    }

    public boolean matchOver(char[] str, char[] pattern, int index1, int index2) {
        if (index1 >= str.length && index2 >= pattern.length) {
            return true;
        }
//        if (index1 >= str.length) {
//            return false;
//        }
        if (index2 >= pattern.length) {
            return false;
        }
        if ((index2 + 1) < pattern.length && pattern[index2 + 1] == '*') {
            return matchOver(str, pattern, index1, index2 + 2) || matchOver(str, pattern, index1 + 1, index2);
        } else if (pattern[index2] == '.') {
            return matchOver(str, pattern, index1 +1, index2+1);
        }else if (index1 < str.length - 1 && str[index1] == pattern[index2]) {
            return matchOver(str, pattern, index1 + 1, index2 + 1);
        }else {
            return false;
        }
    }


    public static void main(String[] args) throws Exception{
        boolean b = RegexMatch.class.newInstance().match("".toCharArray(), ".*".toCharArray());
        System.out.println(b);
    }

}

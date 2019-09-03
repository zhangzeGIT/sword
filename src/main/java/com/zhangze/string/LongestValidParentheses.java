package com.zhangze.string;

import java.util.Stack;

/**
 * Created by zhangze on 2019/8/23
 * 32、Longest Valid Parentheses：最长有效的括号
 *
 * 给一个字符串，仅含有"("或者")"，求出最长有效子串
 *
 * 例子：
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses {
    /**
     * 暴力破解法
     */
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+2; j < s.length(); j+=2) {
                if (isValid(s.substring(i, j))) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }
        return maxLen;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == ')') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }


    /**
     * 动态规划法
     * 初始化一个dp[s.length]，值全为零
     * 一个合法的子字符串必须是以‘）’结尾
     * 我们仅仅当遇到‘）’时更新dp
     * 第一种情况：
     *      s[i] = ')' and s[i-1] = '('
     *      dp[i] = dp[i-2] + 2  代表最后是一个合法的，加上index-2的合法长度
     * 第二种情况：
     *      s[i] = ')' and s[i-1] = ')'
     *      如果s[i - dp[i-1] - 1] = '(' 正好和最后一个配对
     *      则：dp[i] = dp[i-1] + dp[i - dp[i-1] -2] + 2
     *          当前  = 上一个有效的 + 上一个有效的起始值-2的有效长度
     */
    public int longestValidParentheses2(String s) {
        int maxLen = 0;
        int[] arr = new int[s.length()];
        for (int i = 0;i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if ((i - 1) >= 0) {
                    if (s.charAt(i-1) == '(') {
                        if ((i - 2) >= 0) {
                            arr[i] = arr[i-2] + 2;
                        } else {
                            arr[i] = 2;
                        }
                    } else {
                        if ((i - arr[i - 1] -1) >= 0) {
                            if (s.charAt(i - arr[i - 1] -1) == '(') {
                                if ((i - arr[i - 1] -2) > 0){
                                    arr[i] = 2 + arr[i - 1] + arr[i - arr[i - 1] -2];
                                } else {
                                    arr[i] = 2 + arr[i - 1];
                                }
                            }
                        }
                    }
                    maxLen = Math.max(maxLen, arr[i]);
                }
            }
        }
        return maxLen;
    }


    /**
     * 通过stack来解决问题
     *
     * stack存的是s的角标
     * 当s[i] = '('时，将i存入stack
     * 当s[i] = ')'时，弹出一个元素，用i减去弹出元素的值，就是有效长度
     *                  如果没有元素了，就过了
     */
    public int longestValidParentheses3(String s) {
//        int maxLength = 0;
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                stack.push(i);
//            } else if (!stack.empty()){
//                maxLength = Math.max(maxLength, i - stack.pop() + 1);
//            }
//        }
//        return maxLength;
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }










}

package com.zhangze.string;

import java.util.Stack;

/**
 * Created by zhangze on 2019/6/6
 * 20、Valid Parentheses
 * 给一个集合Char,'(', ')', '{', '}', '[' and ']'  判断输入字符串是否是正确的
 *
 * 开括号必须由相同类型的括号关闭。
 * 开括号必须按正确的顺序关闭。
 *
 * Input: "()"
 * Output: true
 *
 * Input: "()[]{}"
 * Output: true
 *
 * Input: "(]"
 * Output: false
 *
 * Input: "([)]"
 * Output: false
 *
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() <= 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < s.length();i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            }else {
                char prior = stack.pop();
                char aim = s.charAt(i);
                if (!isTrue(prior, aim)) {
                    stack.push(prior);
                    stack.push(aim);
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
    public boolean isTrue(char s, char y) {
        if (s == '(' && y == ')')return true;
        if (s == '{' && y == '}')return true;
        if (s == '[' && y == ']')return true;
        return false;
    }

    public static void main(String[] args) throws Exception{
        boolean isValid = ValidParentheses.class.newInstance().isValid("()");
        System.out.println(isValid);
    }
}

package com.zhangze.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangze on 2019/6/13
 *
 * 22、生成括号(*)
 *
 * 给n对括号，写一次程序生成所有的组合
 *
 * For example, given n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        }else {
            for(int c = 0; c < n; ++c) {
                for (String left : generateParenthesis(c)){
                    for (String right : generateParenthesis(n-1-c)) {
                        ans.add("(" + left +")" + right);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) throws Exception{
        List<String> s = GenerateParentheses.class.newInstance().generateParenthesis(3);
        s.forEach(s1 -> System.out.println(s1));
    }
}











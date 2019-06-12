package com.zhangze.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.UIManager.put;

/**
 * Created by zhangze on 2019/6/4
 *
 * 17、 Letter Combinations of a phone number
 *
 * 给定2-9中的两个数字，输出电话号码对应的所有字母组合
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOfaPhoneNumber {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        String a = phone.get(digits.substring(0,1));

        for (int i = 0;i < a.length();i++) {
            result.add(a.substring(i,i+1));
        }
        int j = 1;
        while(j < digits.length()) {
            String s = phone.get(digits.substring(j,j + 1));
            StringBuilder sb;
            List<String> list = new ArrayList<>();
            for (int i = 0;i < result.size();i++) {
                sb = new StringBuilder();
                sb.append(result.get(i));
                for (int m = 0;m < s.length();m++) {
                    sb.append(s, m, m+1);
                    list.add(sb.toString());
                    sb.delete(j,j+1);
                }
            }
            result = list;
            j++;
        }

        return result;
    }

    public static void main(String[] args) throws Exception{
        LetterCombinationsOfaPhoneNumber.class.newInstance().letterCombinations("234");
    }

}

package com.zhangze.string;

/**
 * Created by zhangze on 2019/5/23
 *
 * 14、最长公共前缀
 *
 * 给定一个字符串集合，找出最长的公共前缀，如果没有，返回""
 *
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length <= 1) {
           return strs[0];
        }
        for (int i = 1; i < strs.length;i++) {
            if (strs[i].length() < strs[0].length()) {
                String s = strs[0];
                strs[0] = strs[i];
                strs[i] = s;
            }
        }
        for (int i = 1;i<strs.length;i++) {
            for (int j = 0;j < strs[i].length();j++) {
                if (j < strs[0].length()){
                    if (strs[0].charAt(j) != strs[i].charAt(j)) {
                        strs[0] = strs[0].substring(0,j);
                        break;
                    }
                }
            }
        }
        return strs[0];
    }
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        return aaa(strs,0, strs.length - 1);

    }
    public String getTowCommonPrefix(String first, String second) {
        for (int i = 0;i < first.length();i++) {
            if (i < second.length()){
                if (first.charAt(i) != second.charAt(i)) {
                    return first.substring(0,i);
                }
            }else {
                return first.substring(0,i);
            }
        }
        return "";
    }
    public String aaa(String[] strs, int l ,int r){
        if (l == r) {
            return strs[l];
        }else {
            int min = (l+r)/2;
            String left = aaa(strs, l , min);
            String right = aaa(strs, min + 1,r);
            return getTowCommonPrefix(left, right);
        }
    }

    public static void main(String[] args) throws Exception{
        String[] s = {"flower","flow","flight"};
        LongestCommonPrefix.class.newInstance().longestCommonPrefix(s);
    }
}

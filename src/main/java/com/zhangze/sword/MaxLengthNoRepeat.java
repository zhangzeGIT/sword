package com.zhangze.sword;

import java.util.Arrays;

/**
 * Created by zhangze on 2019/11/18
 * 48、最长不含重复字符的子字符串
 *
 * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。
 * 例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 *
 */
public class MaxLengthNoRepeat {

    public int longestSubStringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;
        int[] preIndexs = new int[26];
        Arrays.fill(preIndexs, -1);
        for (int i = 0;i < str.length();i++) {
            int c = str.charAt(i) - 'a';
            int preI = preIndexs[c];
            if (preI == -1 || i - preI > curLen) {
                curLen++;
            } else {
                maxLen = Math.max(curLen, maxLen);
                curLen = i - preI;
            }
            preIndexs[c] = i;
        }
        maxLen = Math.max(curLen, maxLen);
        return maxLen;
    }















    public static void main(String[] args) {
    }

}

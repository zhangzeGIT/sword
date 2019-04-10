package com.zhangze.string;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhangze on 2019/3/26
 * 给一个字符串，找到最长的不重复字符的子串
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    // 滑动窗孔 O(1)
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0,i = 0,j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }else
                set.remove(s.charAt(i++));
        }
        return ans;
    }
    /// 滑动窗孔 O(1)
    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0,i = 0; j < n;j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i +1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1(
                "abbacd"));
    }
}

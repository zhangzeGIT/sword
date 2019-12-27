package com.zhangze.string;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by zhangze on 2019/9/19
 * 49、Group Anagrams
 * 给定一个String数组，将颠倒字母而形成的字放在一起
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, Map<Character, Integer>> mapMap = new HashMap<>();
        List<List<String>> rs = new ArrayList<>();
        int first = 0;
        for (int i = 0; i < strs.length; i++) {
            String current = strs[i];
            Map<Character, Integer> currentMap = new HashMap<>();
            if (current.length() == 0) {
                currentMap.put(' ', 0);
            }
            for (Character chars : current.toCharArray()) {
                currentMap.put(chars, currentMap.getOrDefault(chars, -1) + 1);
            }
            boolean flag = false;
            for (Map.Entry<Integer, Map<Character, Integer>> entry : mapMap.entrySet()) {
                if (currentMap.size() == entry.getValue().size()) {
                    for (Map.Entry<Character, Integer> entry1 : entry.getValue().entrySet()) {
                        if (currentMap.get(entry1.getKey()) != null
                                && currentMap.get(entry1.getKey()).equals(entry1.getValue())) {
                            flag = true;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                }
                // false代表完全匹配
                if (flag) {
                    rs.get(entry.getKey()).add(current);
                    break;
                }
            }
            if (!flag){
                List<String> s = new ArrayList<>();
                s.add(current);
                rs.add(s);
                mapMap.put(first, currentMap);
                first++;
            }
        }
        System.out.println(rs);
        return rs;
    }


    // discuss
    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public static void main(String[] args) throws Exception{
        String[] arr = {"", ""};
        GroupAnagrams.class.newInstance().groupAnagrams(arr);
    }
}

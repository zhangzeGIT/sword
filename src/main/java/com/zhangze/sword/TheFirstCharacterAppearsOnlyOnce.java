package com.zhangze.sword;

import java.util.Arrays;

/**
 * Created by zhangze on 2019/11/18
 * 50、第一个只出现一次的字符
 *
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 *
 */
public class TheFirstCharacterAppearsOnlyOnce {

    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 0) return -1;
        int[] arr = new int[256];
        Arrays.fill(arr, 0);
        for (char c : str.toCharArray()) {
            arr[c-'0'] = arr[c - '0'] + 1;
        }
        for (int i = 0; i < str.length();i++) {
            if (arr[str.charAt(i) - '0'] == 1) {
                return i;
            }
        }
        return -1;
    }








    public static void main(String[] args) throws Exception{
        TheFirstCharacterAppearsOnlyOnce.class.newInstance().FirstNotRepeatingChar("NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp");
    }



}

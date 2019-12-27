package com.zhangze.sword;

/**
 * Created by zhangze on 2019/12/6
 * 58.1、翻转单词顺序
 *
 * 输入一段句子，句子中单词内字符串顺序不变，但翻转句中的单词
 * 空间复杂度O(n)
 *
 * 例："I am a student."  -> "student. a am I"
 */
public class ReverseString {

    /**
     * 解题思路，先翻转单词，在整体翻转
     */
    public String ReverseSentence(String str) {
        if (str.length()<=0) return str;
        char[] arr = str.toCharArray();
        int index = 0;
        int begin = 0;
        while (begin < str.length()) {
            if (arr[begin] != ' ') {
                begin++;
            } else  {
                swap(arr,index, begin-1);
                index = begin+1;
                begin++;
            }
        }
        swap(arr, index, begin - 1);
        swap(arr, 0, arr.length - 1);
        return new String(arr);
    }

    public void swap(char[] str, int start, int end) {
        while (end > start) {
            char a = str[start];
            str[start] = str[end];
            str[end] = a;
            start++;
            end--;
        }
    }

    public static void main(String[] args) throws Exception{
        ReverseString.class.newInstance().ReverseSentence("I am a student.");
    }


















}

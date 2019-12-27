package com.zhangze.sword;

/**
 * Created by zhangze on 2019/12/6
 * 58.2、左旋转字符串
 *
 * 将一个字符串左旋转：把前面若干个字符转移到字符串的尾部
 *
 * 例如： ab cdef -> cdef ab
 */
public class AnticlockwiseString {

    public String LeftRotateString(String str,int n) {
        if (str.length() <= 0 || str.length() < n) return str;
        char[] arr = str.toCharArray();
        swap(arr, 0, arr.length - 1);
        swap(arr, 0, arr.length - 1 - n);
        swap(arr, arr.length - n, arr.length - 1);
        return new String(arr);
    }

    public void swap(char[] arr, int start, int end) {
        while (end > start) {
            char a = arr[start];
            arr[start] = arr[end];
            arr[end] = a;
            start++;
            end--;
        }
    }










    public static void main(String[] args) throws Exception{
        AnticlockwiseString.class.newInstance().LeftRotateString("abcdefg", 2);
    }



}

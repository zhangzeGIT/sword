package com.zhangze.sword;

import java.util.Arrays;

/**
 * Created by zhangze on 2019/11/18
 * 51.1、字符流中第一个不重复的字符
 *
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *
 * 例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class TheFirstOfStream {
    static int[] arr = new int[256];
    static {
        Arrays.fill(arr, -1);
    }
    static int index = 0;
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (arr[ch] == -1) {
            arr[ch] = index;
        } else if (arr[ch] >= 0) {
            arr[ch] = -2;
        }
        index++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char ch = '#';
        int min = Integer.MAX_VALUE;
        for (int i = 0;i < 256;i++) {
            if (arr[i] >= 0) {
                if (arr[i] < min) {
                    min = arr[i];
                    ch = (char) i;
                }
            }
        }
        return ch;
    }


    public static void main(String[] args) throws Exception{
        TheFirstOfStream theFirstOfStream = TheFirstOfStream.class.newInstance();
        theFirstOfStream.Insert('h');
        System.out.println(theFirstOfStream.FirstAppearingOnce());
        theFirstOfStream.Insert('e');
        System.out.println(theFirstOfStream.FirstAppearingOnce());
        theFirstOfStream.Insert('l');
        System.out.println(theFirstOfStream.FirstAppearingOnce());
        theFirstOfStream.Insert('l');
        System.out.println(theFirstOfStream.FirstAppearingOnce());
        theFirstOfStream.Insert('o');
        System.out.println(theFirstOfStream.FirstAppearingOnce());
        theFirstOfStream.Insert('w');
        System.out.println(theFirstOfStream.FirstAppearingOnce());
        theFirstOfStream.Insert('o');
        System.out.println(theFirstOfStream.FirstAppearingOnce());
        theFirstOfStream.Insert('r');
        System.out.println(theFirstOfStream.FirstAppearingOnce());
        theFirstOfStream.Insert('l');
        System.out.println(theFirstOfStream.FirstAppearingOnce());
        theFirstOfStream.Insert('d');
        System.out.println(theFirstOfStream.FirstAppearingOnce());

    }

}

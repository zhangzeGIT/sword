package com.zhangze.sword;

import java.util.Map;

/**
 * Created by zhangze on 2019/11/12
 * 44、数字序列中的某一位数字
 *
 * 数字以 0123456789101112131415... 的格式序列化到一个字符串中，求这个字符串的第 index 位。
 *
 */
public class IndexOfDigit {

    public int getDigitAtIndex(int index) {
        if (index <= 0) return -1;
        int place = 1;
        while (true) {
            int amount = getAmountOfPlace(place);
            int totalAmount = amount * index;
            if (index < totalAmount) {
                return getDigitAtIndex(index, place);
            }
            index -= totalAmount;
            place++;
        }
    }

    private int getBeginNumberOfPlace(int place) {
        if (place == 1) return 0;
        return (int) Math.pow(10, place - 1);
    }
    // 在place位数组成的字符串中，第index个数
    private int getDigitAtIndex(int index, int place) {
        int beginNumber = getBeginNumberOfPlace(place);
        int shiftNumber = index / place;
        String number = (beginNumber + shiftNumber) + "";
        int count = index % place;
        return number.charAt(count) - '0';
    }
    private int getAmountOfPlace(int place) {
        if (place == 1) return 10;
        return (int) Math.pow(10, place - 1) * 9;
    }














}

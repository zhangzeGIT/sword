package com.zhangze.math;

/**
 * Created by zhangze on 2019/5/23
 *
 * 13、罗马数字转换为整数
 *
 * Example 1:
 * Input: "III"
 * Output: 3
 *
 * Example 2:
 * Input: "IV"
 * Output: 4
 *
 * Example 3:
 * Input: "IX"
 * Output: 9
 *
 * Example 4:
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int result = 0;
        for (int i = arr.length-1;i>=0;i--){
            String sub_string;
            if ((i - 1)>=0){
                sub_string = arr[i - 1] +String.valueOf(arr[i]);
            }else {
                sub_string = String.valueOf(arr[i]);
            }

            if (getInt(sub_string) == 0){
                sub_string = String.valueOf(arr[i]);
                result += getInt(sub_string);
            }else {
                result += getInt(sub_string);
            }
            if (sub_string.length() == 2){
                i--;
            }
        }
        System.out.println(result);
        return result;
    }
    public int getInt(String sub_string) {
        if (sub_string.equals("CM")) {
            return 900;
        }
        if (sub_string.equals("CD")) return 400;
        if (sub_string.equals("XC")) return 90;
        if (sub_string.equals("XL")) return 40;
        if (sub_string.equals("IX")) return 9;
        if (sub_string.equals("IV")) return 4;
        if(sub_string.equals("I"))
            return 1;
        else if(sub_string.equals("V"))
            return 5;
        else if(sub_string.equals("X"))
            return 10;
        else if(sub_string.equals("L"))
            return 50;
        else if(sub_string.equals("C"))
            return 100;
        else if(sub_string.equals("D"))
            return 500;
        else if(sub_string.equals("M"))
            return 1000;
        else return 0;
    }

    public static void main(String[] args) throws Exception{
        System.out.println("ddd".substring(0,0));
    }
}

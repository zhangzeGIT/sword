package com.zhangze.math;

/**
 * Created by zhangze on 2019/5/22
 * 12、Integer to Roman
 *
 * 将数字转化为罗马数组，对应关系如下：
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * Example 1:
 * Input: 3
 * Output: "III"
 *
 * Example 2:
 * Input: 4
 * Output: "IV"
 *
 * Example 3:
 * Input: 9
 * Output: "IX"
 *
 * Example 4:
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 *
 * Example 5:
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num >= 1000) {
            num = num - 1000;
            sb.append("M");
        }
        if (num >= 900) {
            num = num - 900;
            sb.append("CM");
        }
        while (num >= 500) {
            num = num - 500;
            sb.append("D");
        }
        if (num >= 400) {
            num = num - 400;
            sb.append("CD");
        }
        while (num >= 100) {
            num = num - 100;
            sb.append("C");
        }
        if (num >= 90) {
            num = num - 90;
            sb.append("XC");
        }
        while (num >= 50){
            num = num - 50;
            sb.append("L");
        }
        if (num >= 40) {
            num = num - 40;
            sb.append("XL");
        }
        while (num >= 10){
            num = num - 10;
            sb.append("X");
        }
        if (num >= 9){
            num = num - 9;
            sb.append("IX");
        }
        while (num >= 5) {
            num = num - 5;
            sb.append("V");
        }
        if (num >= 4) {
            num = num - 4;
            sb.append("IV");
        }
        while (num >= 1) {
            num = num - 1;
            sb.append("I");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) throws Exception{

        IntegerToRoman.class.newInstance().intToRoman(1994);
    }
}

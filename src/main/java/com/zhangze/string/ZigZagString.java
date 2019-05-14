package com.zhangze.string;

/**
 * 题目六
 *
 * 将一个字符串打印出横Z的样子，行数确定
 *
 * 例：PAYPALISHIRING
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 *      P   A   H   N
 *      A P L S I I G
 *      Y   I   R
 */
public class ZigZagString {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int span = numRows + numRows - 2;
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < numRows;i++) {
            int b = i;
            int minSpan = span - (numRows - (i+1)) * 2;
            while (b < arr.length) {
                sb.append(arr[b]);
                if (i != 0 && i != numRows-1){
                    minSpan = span - minSpan;
                    b += minSpan;
                }else {
                    b += span;
                }
            }
        }
        return sb.toString();
    }
//""PINALSIGYAHRPI""
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String reslut = new ZigZagString().convert(s, 4);
        System.out.println(reslut);
    }
}

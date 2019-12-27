package com.zhangze.string;

/**
 * Created by zhangze on 2019/10/21
 * 67、Add Binary：二进制加法
 * 给定两个字符串，是二进制的格式，进行二进制的加法，并返回二进制的字符串形式
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        if (a.length() <= 0) {
            return b;
        }
        if (b.length() <= 0) {
            return a;
        }
        int aLenth = a.length();
        int bLength = b.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int index = 0;
        while (i < aLenth || i < bLength) {
            int left = i < aLenth ? a.charAt(aLenth - i - 1) - '0' : 0;
            int right = i < bLength ? b.charAt(bLength - i - 1) - '0' : 0;
            int result = left + right + index;
            if (result >= 2) {
                index = 1;
                sb.append(result - 2);
            } else {
                index = 0;
                sb.append(result);
            }
            i++;
        }
        if (index == 1) {
            sb.append(index);
        }
        sb.reverse();
        System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     * discuss 解法差不多
     */
    public String addBinary1(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) throws Exception{
        AddBinary.class.newInstance().addBinary("1010", "1011");
    }

}

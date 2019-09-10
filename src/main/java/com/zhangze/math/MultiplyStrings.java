package com.zhangze.math;

/**
 * Created by zhangze on 2019/9/5
 * 43、Multiply Strings
 *
 * 给一个非负整数num1和num2，用字符串表示，返回两个整数的乘积
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        int[] arr = new int[num1.length() + num2.length()];
        int carry = 0;
        if (num1.equals("0")) {
            return num1;
        }
        if (num2.equals("0")) {
            return num2;
        }
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();

        int leftEnd = char1[0] == '-'? 1 : 0;
        int rightEnd = char2[0] == '-' ? 1 : 0;

        for (int i = char1.length-1;i >=leftEnd;i--) {
            for (int j = char2.length - 1;j >= rightEnd; j--) {
                if (char1[i] == '-' || char2[j] == '-') {
                    continue;
                }
                int r = (char1[i] - '0') * (char2[j] - '0');
                carry = r / 10;
                arr[i + j + 1] = (arr[i + j + 1] + r%10);
                if (arr[i + j +1] > 9) {
                    arr[i + j + 1] =  arr[i + j + 1] - 10;
                    arr[i + j] = arr[i + j] + 1;
                }
                arr[i + j] = arr[i + j] + carry;
                if (arr[i + j] > 9) {
                    arr[i + j - 1] = arr[i + j -1] + 1;
                    arr[i + j] = arr[i + j] - 10;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (leftEnd != rightEnd) {
            sb.append('-');
        }
        boolean flag = true;
        for (int i = 0;i < arr.length;i++) {
            if (flag && arr[i] == 0) {
            } else {
                flag = false;
                sb.append(arr[i]);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();

    }


    public static void main(String[] args) throws Exception{
        MultiplyStrings.class.newInstance().multiply("2","3");
    }







}

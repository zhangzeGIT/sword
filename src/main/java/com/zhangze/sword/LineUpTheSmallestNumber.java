package com.zhangze.sword;

import java.util.Arrays;

/**
 * Created by zhangze on 2019/11/12
 * 45、把数组排成最小的数
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 */
public class LineUpTheSmallestNumber {


    public String PrintMinNumber(int [] numbers) {
        for (int i = 0; i <numbers.length - 1;i++) {
            for (int j = i + 1;j < numbers.length;j++) {
                String index = String.valueOf(numbers[i]);
                String current = String.valueOf(numbers[j]);
                if ((index + current).compareTo(current +index) > 0) {
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i : numbers) {
            sb.append(i);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }


    public String PrintMinNumber1(int [] numbers) {
        String[] a = new String[numbers.length];
        for (int i = 0; i < numbers.length;i++) {
            a[i] = numbers[i] + "";
        }
        Arrays.sort(a, ((o1, o2) -> (o1 + o2).compareTo(o2 + o1)));
        String ret = "";
        for (String s : a) {
            ret += s;
        }
        return ret;

    }

    public static void main(String[] args) throws Exception{

        int[] arr = {3,5,1,4,2};
        LineUpTheSmallestNumber.class.newInstance().PrintMinNumber(arr);




    }




}

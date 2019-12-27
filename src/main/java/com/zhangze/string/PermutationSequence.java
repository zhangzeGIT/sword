package com.zhangze.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangze on 2019/9/30
 * 60、Permutation Sequence : 排列序列
 * set [1,2,3,4……，n]一共有n!个不重复的序列
 * 返回序列排序之后的第n个
 *
 * 例如：n = 3
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 第三个就是 ： 213
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
       List<Integer> numbers = new ArrayList<>();
       StringBuilder sb = new StringBuilder();
       int sum = 1;
       int[] factorial = new int[n+1];
       factorial[0] = 1;
       for (int i = 1;i <= n;i++) {
           sum*=i;
           factorial[i] = sum;
       }
       for (int i = 1; i <= n;i++) {
           numbers.add(i);
       }
       k--;
       for (int i = 1;i <= n;i++) {
           int index = k/factorial[n - i];
           sb.append(numbers.get(index));
           numbers.remove(index);
           k-= index * factorial[n - i];
       }
       return String.valueOf(sb);

    }


    public static void main(String[] args) throws Exception{
        PermutationSequence.class.newInstance().getPermutation(4,9);
    }











}

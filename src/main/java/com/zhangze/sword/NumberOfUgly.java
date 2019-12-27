package com.zhangze.sword;

/**
 * Created by zhangze on 2019/11/18
 * 49、丑数
 *
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class NumberOfUgly {

    /**
     * 思路：只计算丑数，不计算其他的数，每次乘以2,3,5，最小的值就是下一个丑数
     */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        int[] arr = new int[index];
        arr[0] = 1;
        int i = 1;
        int index2 = 0, index3 = 0, index4 = 0;
        while (i < index) {
            int min= Math.min(Math.min(2 * arr[index2], 3 * arr[index3]) ,5 * arr[index4]);
            arr[i] = min;
            if (arr[index2] * 2 == min) {
                index2++;
            }
            if (arr[index3] * 3 == min) {
                index3++;
            }
            if (arr[index4] * 5 == min) {
                index4++;
            }
            i++;
        }
        return arr[index - 1];
    }










    public static void main(String[] args) throws Exception{
        NumberOfUgly.class.newInstance().GetUglyNumber_Solution(3);
    }

}

package com.zhangze.sword;

/**
 * Created by zhangze on 2019/12/11
 * 61、扑克牌中的顺子
 *
 * 从扑克牌中随机抽出五张牌，判断是不是一个顺子，即这五张牌是不是连续的
 * 2到10为数字本身，A为1，J为11，Q为12，K为13 大小王可以看成任意字符串(大小王看成数字0)
 */
public class TheOrderOfCard {


    /**
     * CS-Nodes上的解法：排序，统计零的个数，然后从不为零的那位开始，numbers[i+1]-numbers[i]-1，再用零的个数减去这个值，如果最后零的个数大于等于零，就返回true
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        if (numbers.length != 5) return false;
        boolean[] arr = new boolean[5];
        int min = 13;
        int max = 0;
        for (int i : numbers) {
            if (i != 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }
        if (max - min >= 5) {
            return false;
        }
        for (int i :numbers) {
            if (i != 0) {
                if (!arr[i-min]) arr[i - min] = true;
                else return false;
            }
        }
        return true;
    }




    public static void main(String[] args) throws Exception{
        int[] arr = {1,2,5,3,4};
        TheOrderOfCard.class.newInstance().isContinuous(arr);
    }
}

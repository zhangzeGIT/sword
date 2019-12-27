package com.zhangze.sword;

/**
 * Created by zhangze on 2019/11/15
 *
 * 47、礼物的最大值
 * 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。
 * 从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。
 * 给定一个棋盘，求拿到礼物的最大价值。例如，对于如下棋盘
 * 1    10   3    8
 * 12   2    9    6
 * 5    7    4    11
 * 3    7    16   5
 *
 * 礼物的最大价值为 1+12+5+7+7+16+5=53。
 */
public class MaxOfGift {




    public int getMost(int[][] values) {
        if (values.length <= 0) return 0;
        int[][] res = new int[values.length][values[0].length];
        res[0][0] = values[0][0];
        for (int i = 1; i < values[0].length;i++) {
            res[0][i] = values[0][i] + res[0][i-1];
        }
        for (int i = 1; i < values.length;i++) {
            res[i][0] = values[i][0] + res[i-1][0];
        }
        // 行
        for (int i = 1; i < values.length;i++) {
            for (int j = 1;j < values[0].length;j++) {
                res[i][j] = Math.max(res[i-1][j], res[i][j-1]) + values[i][j];
            }
        }
        return res[values.length-1][values[0].length - 1];
    }


    public static void main(String[] args) {

        System.out.println(Integer.valueOf(1) == Integer.valueOf(1));
    }







}

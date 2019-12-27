package com.zhangze.sword;

/**
 * Created by zhangze on 2019/12/18
 * 63、股票的最大利润
 * 可以有一次买入和一次卖出，买入必须在前。求最大收益
 */
public class MaximumProfit {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int min = prices[0];
        int max = 0;
        for (int i = 1;i < prices.length;i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else {
                max = Math.max(prices[i] - min, max);
            }
        }
        return max;
    }



    public static void main(String[] args) {

    }
}

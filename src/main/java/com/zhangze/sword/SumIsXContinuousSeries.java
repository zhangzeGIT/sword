package com.zhangze.sword;

import java.util.ArrayList;

/**
 * Created by zhangze on 2019/12/5
 * 57.2、和为S的连续正数序列
 *
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 */
public class SumIsXContinuousSeries {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int first = 1;
        int second = 2;
        int max = 3;
        while (second <= sum / 2 + 1) {
            if (sum == max) {
                ArrayList<Integer> res1 = new ArrayList<>();
                for (int i = first;i <= second;i++) {
                    res1.add(i);
                }
                max-=first;
                first++;
                second++;
                max+=second;
                res.add(res1);
            } else if (max < sum) {
                second = second + 1;
                max += second;
            } else {
                max -= first;
                first++;
                if (first == second) break;
            }
        }
        return res;
    }




    public static void main(String[] args) throws Exception{

        SumIsXContinuousSeries.class.newInstance().FindContinuousSequence(9);
    }

}

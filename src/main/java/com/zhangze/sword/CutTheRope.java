package com.zhangze.sword;

import java.util.HashMap;
import java.util.Map;

/**
 * 14、剪绳子
 *
 * 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CutTheRope {

    public int cutRope(int target) {
        Map<Integer, Integer> map = new HashMap<>();
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 0;
        }

        map.put(1, 1);
        int i = 2;
        while (i <= target) {
            map.put(i, 0);
            for (int j = 1;j <= i / 2; j++) {
                map.put(i, Math.max(map.get(i), Math.max(j, map.get(j)) * Math.max(i-j, map.get(i - j))));

            }
            i++;
        }
        return map.get(target);
    }





    public static void main(String[] args) throws Exception{
        System.out.println(CutTheRope.class.newInstance().cutRope(2));
    }
}

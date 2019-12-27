package com.zhangze.sword;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangze on 2019/12/11
 * 62、圆圈中最后剩下的数字
 *
 *
 * 0,1,2，……，n-1这n个数字排成一个圆圈
 * 从数字0开始，每次从这个圆圈里删除第m个数字，求出这个圆圈里剩下的最后一个数字
 */
public class TheLastNumberInCircle {


    /**
     * 设f(n, m)是n个数字，删除第m个数，剩下的最后一个数字
     * f(n, m)第一个删除的数字为 k = (m - 1) % n
     *
     * 设f(n-1, m)是上述删除第m个数之后，继续删除第m个数，剩下的最后一个数字
     * 所以f(n, m) = f(n - 1, m)
     * 但是f(n-1,m)的起始位置是k + 1，而不是0，所以，之前位置的数字如果是x，那么这一轮的数字就是(x + k + 1) % n
     * 所以，本来f(n-1,m)这次要删除的第一个数字是x（如果其实位置是0），但实际就是(x + k + 1) % n
     * 将k带入，得到x -> (x + m) % n的映射
     *
     * 所以f(n, m) = (f(n-1, m) + m) % n 当n > 1时，当n = 1时，f(n, m) = 0
     */
    public int LastRemaining_Solution(int n, int m) {

        if (n == 0) return -1;
        if (n == 1) return 0;
        return (LastRemaining_Solution(n - 1, m) + m) % n;
    }


    public static void main(String[] args) throws Exception{
        Map<String, String> map = new HashMap<>();
        map.put("1","1");
        System.out.println(map.get("1"));
        System.out.println(map.get("2"));
    }
}

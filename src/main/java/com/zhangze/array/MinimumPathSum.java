package com.zhangze.array;

/**
 * Created by zhangze on 2019/3/21
 * 64、Minimum Path Sum：路径之和最小
 * 给定一个M*N的表格，都是正数，找到一个path，从左上角到右下角，使得路径上所有正数的和最小
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 */
public class MinimumPathSum implements Cloneable{

    public int result(int[][] arr) {
        if (arr.length <= 0) {
            return 0;
        }
        int hang = arr.length;
        int lie = arr[0].length;
        int[][] ret = new int[hang][lie];
        ret[0][0] = arr[0][0];
        for (int i = 1;i < lie;i++) {
            ret[0][i] = ret[0][i-1] + arr[0][i];
        }
        for (int j = 1; j < hang;j++) {
            ret[j][0] = ret[j-1][0] + arr[j][0];
        }
        for (int i = 1; i < hang;i++) {
            for (int j = 1; j < lie ;j++) {
                ret[i][j] = Math.min(ret[i-1][j], ret[i][j-1]) + arr[i][j];
            }
        }
        System.out.println(ret[hang-1][lie-1]);
        return ret[hang-1][lie-1];
    }


    public static void main(String[] args) throws Exception{
        int[][] arr = {{1,3,1},{1,5,1}};
        MinimumPathSum.class.newInstance().result(arr);
    }
}

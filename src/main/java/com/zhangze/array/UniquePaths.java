package com.zhangze.array;

/**
 * Created by zhangze on 2019/10/10
 * 62、Unique Paths：唯一路径
 * 一个机器人在M*N的网格中的左上角，求，这个机器人去右下角一共有多少种走法
 * 机器人只能往下走和往右走
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 *
 *
 * Example 2:
 *
 * Input: m = 7, n = 3
 * Output: 28
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1) {
            return 1;
        }
        int[][] arr = new int[m][n];
        arr[0][0] = 0;
        for (int i = 1;i < m;i++) {
            arr[i][0] = 1;
        }
        for (int i = 1;i < n; i++) {
            arr[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        System.out.println(arr[m-1][n-1]);
        return arr[m-1][n-1];
    }
















    public static void main(String[] args) throws Exception{
        UniquePaths.class.newInstance().uniquePaths(7, 3);
    }

}

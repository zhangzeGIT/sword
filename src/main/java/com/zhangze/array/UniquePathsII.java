package com.zhangze.array;

/**
 * Created by zhangze on 2019/10/10
 * 63、Unique Paths II：唯一路径二
 * 问题同上，只是增加了一些障碍
 *
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length <= 0) {
            return 1;
        }

        int[][] arr = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length;j++) {
                if (i == 0) {
                    arr[i][j] = 1;
                    if (obstacleGrid[i][j] == 1) {
                        arr[i][j] = 0;
                    }
                    if (j - 1 >= 0 && arr[i][j-1] == 0) {
                        arr[i][j] = 0;
                    }
                } else if (j == 0) {
                    arr[i][j] = 1;
                    if (obstacleGrid[i][j] == 1) {
                        arr[i][j] = 0;
                    }
                    if (i - 1 >= 0 && arr[i-1][j] == 0) {
                        arr[i][j] = 0;
                    }
                } else {
                    arr[i][j] = arr[i-1][j] + arr[i][j-1];
                    if (obstacleGrid[i][j] == 1) {
                        arr[i][j] = 0;
                    }
                }
            }
        }
        System.out.println(arr[arr.length-1][arr[0].length-1]);
        return arr[arr.length-1][arr[0].length-1];
    }












    public static void main(String[] args) throws Exception{
        int[][] arr = {{1,0}};
        UniquePathsII.class.newInstance().uniquePathsWithObstacles(arr);
    }

}

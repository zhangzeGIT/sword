package com.zhangze.array;

/**
 * Created by zhangze on 2019/9/18
 * 48、Rotate Image:旋转图片
 * 给定一个N*N的2D矩阵，想象成一个图片，将其旋转90度
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 *
 * Example 2:
 *
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class RotateImage {

    /**
     * 0-0 -》 0-3
     * 1-1 -》 1-2
     * 2-0 -》 0-1
     * 3-3 -》 3-0
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for ( int i = 0;i < n / 2; i++) {
            for (int j = 0;j < n - 1 - 2 * i; ++j) {
                int temp = matrix[i][i + j];
                matrix[i][i + j] = matrix[n - 1 - i - j][i];
                matrix[n - 1 - i - j][i] = matrix[n - 1 - i][n - 1 - i - j];
                matrix[n - 1 - i][n - 1 - i - j] = matrix[i + j][n - 1 - i];
                matrix[i + j][n - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        int[][] arr = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        RotateImage.class.newInstance().rotate(arr);
        System.out.println(arr);
    }

}

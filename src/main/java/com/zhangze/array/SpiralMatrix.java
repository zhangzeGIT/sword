package com.zhangze.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangze on 2019/9/23
 * 54、Spiral Matrix：螺旋矩阵
 * 给一个矩阵，m*n，返回所有元素，按照螺旋排序
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length <= 0) {
            return list;
        }
        int hang = matrix.length;
        int lie = matrix[0].length;
        for (int i = 0,k = 0; i < hang - hang / 2 && k < lie - lie %2;i++,k++) {
            for (int j = i;j < lie - i;j++) {
                list.add(matrix[i][j]);
            }
            for (int j = i + 1;j<= hang - i - 1;j++) {
                list.add(matrix[j][lie - i - 1]);
            }
            if ((i) != (hang / 2)) {
                for (int j = lie - i - 2; j >= i; j--) {
                    list.add(matrix[hang - i - 1][j]);
                }
            } else {
                break;
            }
            if (i != lie - i - 1) {
                for (int j = hang - i - 2;j>i;j--) {
                    list.add(matrix[j][i]);
                }
            } else {
                break;
            }

        }
        list.forEach(System.out::println);
        return list;
    }


    public static void main(String[] args) throws Exception{
        int[][] a = {{1,2,3},{4,5,6}};
        SpiralMatrix.class.newInstance().spiralOrder(a);
    }

















}

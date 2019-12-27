package com.zhangze.array;

/**
 * Created by zhangze on 2019/9/30
 * 59、Spiral Matrix II
 *
 * 给定一个正整数N，生成一个由1到N*N的元素按照螺旋顺序填充的方阵
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        if (n <= 0) {
            return arr;
        }
        int k = 0;
        for (int i = 0;i < (n / 2 + n % 2);i++) {
            int first = 0;
            int second = 1;
            int three = n - 2;
            int four = n - 2;
            while (first+i <n - i) {
                arr[i][first + i] = ++k;
                first++;
            }
            while (second + i <n - i){
                arr[second+i][n - 1 - i] = ++k;
                second++;
            }
            while (three - i >= i) {
                arr[n - 1 - i][three - i] = ++k;
                three--;
            }
            while (four - i > i) {
                arr[four - i][i] = ++k;
                four--;
            }
        }
        return arr;
    }


    public static void main(String[] args) throws Exception{
        SpiralMatrixII.class.newInstance().generateMatrix(4);


    }

}

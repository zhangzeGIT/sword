package com.zhangze.sword;

/**
 * Created by zhangze on 2019/10/24
 * 4、二维数组中的查找
 *
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindInArray {

    /**
     * 思路：从右上角开始找起，如果右上角的>target，则整列可以排除
     * 如果右上角<target，则整行可以排除
     */
    public boolean Find(int target, int [][] array) {
        if (array.length <= 0) {
            return false;
        }
        if (array[0].length <= 0) {
            return false;
        }
        if (target < array[0][0] || target > array[array.length-1][array[0].length-1]) {
            return false;
        }
        int i = 0,j = array[0].length - 1;
        while (i< array.length && j >= 0) {
            if (array[i][j] > target) {
                j--;
                continue;
            }
            if (array[i][j] < target) {
                i++;
                continue;
            }
            if (array[i][j] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        int[][] arr = {{1,2,3,4,6}};
        boolean is = FindInArray.class.newInstance().Find(7, arr);
        System.out.println(is);
    }

}

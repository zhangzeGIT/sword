package com.zhangze.sword;

/**
 * 12、矩阵中的路径
 *
 * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如
 * 【a b c e 】
 * 【s f c s 】
 * 【a d e e】 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子
 */
public class MatrixPath {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix.length <= 0 || str.length <= 0) {
            return false;
        }

        boolean[] b = new boolean[matrix.length];

        for (int i = 0;i < b.length; i++) {
            b[i] = false;
        }

        for (int i = 0;i < matrix.length;i++) {
            if (matrix[i] == str[0]) {
                b[i] = true;
                boolean shang = (i - cols) >= 0 && isTrue(b, matrix, str, i - cols, 1, rows, cols);
                boolean xia = (i + cols) < matrix.length && isTrue(b, matrix, str, i +cols, 1,rows, cols);
                boolean zuo = (i % cols) != 0 && isTrue(b, matrix, str, i - 1, 1,rows, cols);
                boolean you = (i % cols) != cols - 1 && isTrue(b, matrix, str, i + 1, 1, rows,cols);
                boolean res = shang || xia || zuo || you;
                if (res || str.length == 1) {
                    return true;
                }
                b[i] = false;
            }
        }

        return false;
    }

    private boolean isTrue(boolean[] b, char[] matrix, char[] str, int indexMatrix, int indexStr, int rows, int cols) {
        if (indexStr >= str.length) {
            return true;
        }
        if (b[indexMatrix]) {
            return false;
        }
        if (matrix[indexMatrix] == str[indexStr]) {
            b[indexMatrix] = true;
            int i = indexMatrix;

            boolean shang = (i - cols) >= 0 && isTrue(b, matrix, str, i - cols, indexStr + 1, rows, cols);
            boolean xia = (i + cols) < matrix.length && isTrue(b, matrix, str, i +cols, indexStr + 1,rows, cols);
            boolean zuo = (i % cols) != 0 && isTrue(b, matrix, str, i - 1, indexStr + 1,rows, cols);
            boolean you = (i % cols) != cols - 1 && isTrue(b, matrix, str, i + 1, indexStr + 1, rows,cols);
            boolean res = shang || xia || zuo || you;
            if (res) {
                return true;
            }
            b[indexMatrix] = false;
        }
        return false;
    }












    public static void main(String[] args) throws Exception{
        boolean b = MatrixPath.class.newInstance().hasPath("A".toCharArray(), 1,1,"A".toCharArray());
        System.out.println(b);
    }

}

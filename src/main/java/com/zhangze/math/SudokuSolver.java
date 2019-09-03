package com.zhangze.math;

/**
 * Created by zhangze on 2019/9/3
 * 37、解决数独问题
 *
 * 给一个9*9的数组，填满数独
 * 1、每行每列必须是1-9
 * 2、每个三乘三小表格必须是1-9
 * 空格子中方的是‘.’
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length;j ++) {
                if (board[i][j] == '.') {
                    for (char c = '1';c < '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0;i < 9;i++)  {
            if (board[i][col] != '.' && board[i][col] == c) return false;
            if (board[row][i] != '.' && board[row][i] == c) return false;
            if (board[3 * row / 3 + i / 3][3*(col / 3) + i % 3] != '.'
                && board[3*(row/3) + i/3][3*(col / 3) + i % 3] == c) return false;
        }
        return true;
    }













    public static void main(String[] args) throws Exception{

    }






}

package com.zhangze;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangze on 2019/12/4
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        if (matrix[0].length == 0) return res;

        int left1 = 0;
        int left2 = 0;
        int right1 = matrix.length;
        int right2 = matrix[0].length;

        for (int i = 0;i < (matrix.length + 1) / 2;i++) {
            int a = left1,b = left2 + 1,c = right2 - 2, d = right1 - 2;
            while (a < right2) {
                res.add(matrix[i][a]);
                a++;
            }
            while (b < right1) {
                res.add(matrix[b][right2 - 1 - i]);
                b++;
            }
            while (c >= i && right1 - 1 > left1) {
                res.add(matrix[right1 - 1 - i][c]);
                c--;
            }
            while (d > i && right2 - 1 > left1) {
                res.add(matrix[d][i]);
                d--;
            }
            left1++;
            left2++;
            right1--;
            right2--;
        }
        return res;
    }

    public static void main(String[] args) throws Exception{
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] arr1 = {{1},{2},{3},{4},{5},{6},{7},{8},{9},{10}};
        Solution.class.newInstance().spiralOrder(arr1);
    }
}

class Solution1 {
    /**
     * top-left coordinated(r1,c1)
     * bottom-right coordinated(r2,c2)
     * Top：   c  C1-->C2            上下比较
     * Bottom：c  C2 + 1-->C1 + 1
     * Right： r  R1 + 1-->R2        左右比较
     * Left：  r  R2 + 1-->R1 + 1
     */
    public List < Integer > spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0)
            return ans;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);
                for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }
}

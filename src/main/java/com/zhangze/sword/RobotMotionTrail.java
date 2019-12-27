package com.zhangze.sword;

/**
 * 13、机器人运动轨迹
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class RobotMotionTrail {

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] b = new boolean[rows][cols];
        if (rows == 0 || cols == 0) {
            return 0;
        }
        return moving(b, threshold, rows, cols, 0, 0);
    }

    public int moving(boolean[][] b, int threshold, int rows, int cols, int heng, int shu) {
        if (heng <0 || heng >= cols) {
            return 0;
        }
        if (shu < 0 || shu >= rows) {
            return 0;
        }
        if (b[heng][shu]) {
            return 0;
        }
        if (canIn(heng, shu, threshold)) {
            b[heng][shu] = true;
            int shang = moving(b, threshold, rows, cols, heng - 1, shu);
            int xia = moving(b, threshold, rows, cols, heng + 1, shu);
            int zuo = moving(b, threshold, rows, cols, heng, shu - 1);
            int you = moving(b, threshold, rows, cols, heng, shu + 1);
            return 1 + shang + xia+zuo+you;
        }
        b[heng][shu] = true;
        return 0;
    }

    public boolean canIn(int heng, int shu, int threshold) {
        int max = 0;
        while (heng > 0) {
            max = max + heng % 10;
            heng = heng / 10;
        }
        while (shu > 0) {
            max = max + shu % 10;
            shu = shu / 10;
        }
        if (max > threshold) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) throws Exception{
        int a = RobotMotionTrail.class.newInstance().movingCount(5, 10, 10);
        System.out.println(a);
    }

















}

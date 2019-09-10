package com.zhangze.array;

/**
 * Created by zhangze on 2019/9/4
 * 42、Trapping Rain Water
 *
 * 给定一个正数，代表海拔高低，计算如果下雨，会储存多少雨水
 *
 *  3\
 *  2\   -
 *  1\ -  -
 *  0\----------------------------
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length <= 0) {
            return 0;
        }
        int leftMax = height[0];
        int trap = 0;
        int left = height.length;
        int[] arr = new int[height.length];
        int max = 0;
        for (int j = height.length -1;j >=0;j--) {
            if (height[j] > max) {
                max = height[j];
            }
            arr[j]=max;
        }
        for (int i = 1;i < left;i++) {
            if (height[i] < leftMax) {
                trap = trap + (Math.min(arr[i],leftMax) - height[i]);
            } else {
                leftMax = height[i];
            }
        }
        return trap;
    }


    public static void main(String[] args) throws Exception{
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int b = TrappingRainWater.class.newInstance().trap(arr);
        System.out.println(b);
    }














}

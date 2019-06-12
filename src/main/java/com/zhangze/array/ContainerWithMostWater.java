package com.zhangze.array;

/**
 * Created by zhangze on 2019/5/22
 * 11、container with most water
 *
 * 给定n各非负数，a1,a2,a3……对应的左边分别是（1,a1）(2,a2)(3,a3)……
 * 找出两个点，垂直连接x轴，所组成的杯子，能装最多的水
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        if (height.length < 2) {
            return max;
        }
        for (int i = 0;i < height.length;i++) {
            for (int j = i+1;j < height.length;j++) {
                int min = Math.min(height[i],height[j]);
                max = max < (j-i) * min ?(j-i) * min:max;
            }
        }
        System.out.println(max);
        return max;
    }
    // 两个指示器慢慢接近
    public int maxArea2(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        int start = 0;
        int end = arr.length - 1;
        int max = 0;
        while (end > start) {
            int min = Math.min(arr[start],arr[end]);
            max = max > min * (end-start)?max : min * (end-start);
            if (min == arr[start]) {
                start++;
            }else {
                end--;
            }
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) throws Exception{
        int[] arr = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater.class.newInstance().maxArea2(arr);
    }
}


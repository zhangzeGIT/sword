package com.zhangze.array;

/**
 * 第四题：
 * 找到两个排序数组的中值，时间复杂度为O(log(m+n))
 * 两个数组不能全为空
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {
    public double getMedia(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        if (m > n) {
            int[] tmp = arr1;arr1 = arr2;arr2 = tmp;
            int temp = m; m = n;n = temp;
        }
        int iMin = 0;
        int iMax = m;
        int halfLen = (m + n + 1) / 2;
        while(iMin <= iMax) {
            // 第一个数组取到哪里
            int i = (iMin + iMax) / 2;
            // 第二个数组取到中值减去第一个数组取到的数
            int j = halfLen - i;
            // i is too small
            if (i < iMax && arr2[j - 1] > arr1[i]) {
                iMin = i + 1;
            }
            // i is to big
            else if (i > iMin && arr1[i - 1] > arr2[j]){
                iMax = i - 1;
            }
            // i is perfect
            else {
                // 左侧的最大值
                int maxLeft = 0;
                if (i == 0) maxLeft = arr2[j - 1];
                else if (j == 0) maxLeft = arr1[i - 1];
                else maxLeft = Math.max(arr1[i - 1], arr2[j - 1]);
                // 如果是奇数
                if ((m + n) % 2 == 1) return maxLeft;

                // 右侧的最大值
                int minRight = 0;
                if (i == m) minRight = arr2[j];
                else if (j == n) minRight = arr1[i];
                else minRight = Math.min(arr1[i], arr2[j]);

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}

package com.zhangze.array;

import java.util.Arrays;

/**
 * Created by zhangze on 2019/9/2
 * 34、Find first and last position of element in sorted array
 * 给定一个升序排序的整形数组，给定一个元素，查找这个元素在数组中的起始和结束的角标
 * 时间复杂度必须是O（log n）
 * 如果没有找到，返回(-1,-1)
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {

        int[] result = {-1,-1};

        if (nums.length == 0) {
            return result;
        }

        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (right >= left) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if ((mid - 1) < 0 || nums[mid - 1] < target) {
                    index = mid;
                    break;
                }
                right = mid - 1;
                continue;
            }
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (index == -1) {
            return result;
        }
        result[0] = index;
        index = -1;
        left = result[0];
        right = nums.length - 1;
        while (right >= left) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if ((mid + 1) > nums.length-1|| nums[mid + 1] > target) {
                    index = mid;
                    break;
                }
                left = mid + 1;
                continue;
            }
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        result[1] = index;
        return result;
    }


    public static void main(String[] args) throws Exception {
        int[] nums = {2,2};
        int[] arr = FindFirstAndLastPositionOfElementInSortedArray.class.newInstance().searchRange(nums, 2);
        Arrays.stream(arr).forEach(x -> System.out.println(x));
    }






























}

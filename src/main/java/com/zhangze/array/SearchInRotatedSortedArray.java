package com.zhangze.array;

/**
 * Created by zhangze on 2019/8/30
 *
 * 33、search in rotated sorted array : 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1
 * 数组中不存在重复元素
 *
 * 时间复杂度必须是O（log n）级别
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0 , nums.length - 1);
    }

    public int helper(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            if (target == arr[start]) {
                return start;
            } else {
                return -1;
            }
        }
        int mid = (start + end)/2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[start] <= target && arr[mid] > target) {
            return helper(arr, target, start, mid - 1);
        } else if (arr[start] > target && arr[start] < arr[mid] && arr[mid] > target) {
            return helper(arr, target, mid + 1, end);
        }
        return Math.max(helper(arr, target, start, mid - 1), helper(arr, target, mid + 1, end));
    }



    public static void main(String[] args) throws Exception{
        int[] arr = {4,5,6,7,0,1,2};
        int a = SearchInRotatedSortedArray.class.newInstance().search(arr, 0);
        System.out.println(a);
    }





}

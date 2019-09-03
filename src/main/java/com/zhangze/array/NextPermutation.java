package com.zhangze.array;

import java.util.Arrays;

/**
 * Created by zhangze on 2019/8/21
 * 31、next permutation：下一个排列
 *
 * 实现获取下一个排列函数，将数字序列重新排列成字典序中下一个更大的排列
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列
 * 必须原地修改，只允许使用额外常熟空间
 *
 *
 * 例子
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int[] back = new int[nums.length];
        System.arraycopy(nums, 0, back, 0, nums.length);
        boolean rt = false;
        for (int i = nums.length  - 1;i >= 0;i--) {
            int corner = nums[i];
            for (int j = nums.length - 1;j > i;j--) {
                if (nums[j] > corner) {
                    int num = back[i];
                    back[i] = back[j];
                    back[j] = num;
                    rt = true;
                    sort(back, i + 1);
                    break;
                }
            }
            if (rt) {
                break;
            }
        }
        if (rt) {
            System.arraycopy(back, 0, nums, 0 ,nums.length);
        } else {
            for (int i = 0;i < nums.length/2;i++) {
                int aa = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = aa;
            }
        }
    }

    private void sort(int[] arr, int start) {
        for (int i = start;i < arr.length - 1;i++) {
            for (int j = i + 1;j < arr.length;j++) {
                if (arr[i] > arr[j]) {
                    int aa = arr[i];
                    arr[i] = arr[j];
                    arr[j] = aa;
                }
            }
        }
    }


    /**
     * 标准答案
     */
    public void nextPermutation1(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) throws Exception{
        int[] arr = {1, 3, 2};
        NextPermutation.class.newInstance().nextPermutation(arr);
        System.out.println(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}

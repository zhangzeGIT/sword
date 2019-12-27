package com.zhangze.sword;

/**
 * Created by zhangze on 2019/11/19
 * 51、数组中的逆序对
 *
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 	对于%50的数据,size<=10^4
 * 	对于%75的数据,size<=10^5
 * 	对于%100的数据,size<=2*10^5
 *
 *
 */
public class InversionsOfArray {

    private long cnt = 0;

    private int[] tmp;

    public int InversePairs(int [] array) {
        tmp = new int[array.length];
        mergeSort(array, 0, array.length - 1);
        return (int)(cnt % 1000000007);
    }

    public void mergeSort(int[] array, int start, int end) {
        if (end > start) {
            int mid = start + (end - start) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            sort(array, start, mid, end);
        }
    }
    public void sort(int[] arr, int start, int mid, int end) {
        int i = start, j = mid + 1, k = start;
        while (i <= mid || j <= end) {
            if (i > mid) {
                tmp[k] = arr[j++];
            } else if (j > end) tmp[k] = arr[i++];
            else if (arr[i] <= arr[j]) tmp[k] = arr[i++];
            else {
                tmp[k] = arr[j++];
                this.cnt += mid - i + 1;// nums[i] > nums[j]，说明 nums[i...mid] 都大于 nums[j]
            }
            k++;
        }
        for (k = start;k <= end;k++)
            arr[k] = tmp[k];
    }


    public static void main(String[] args) throws Exception {
        int[] arr = {5,3,7,1,3,9,6,4,7};
        InversionsOfArray.class.newInstance().InversePairs(arr);

    }



}

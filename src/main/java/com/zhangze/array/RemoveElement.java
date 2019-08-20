package com.zhangze.array;

/**
 * Created by zhangze on 2019/8/9
 * 27、移除指定元素
 * 给定一个集合个集合中的一个元素，移除集合中的这个元素，并返回集合的长度
 *
 * 例：
 * Given nums = [3,2,2,3], val = 3,
 *
 * Your function should return length = 2, with the first two elements of nums being 2.
 *
 * It doesn't matter what you leave beyond the returned length.
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums.length <= 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0;i < nums.length;i++) {
            if (val != nums[i]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;

    }

}

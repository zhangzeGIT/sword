package com.zhangze.sword;

/**
 * Created by zhangze on 2019/11/8
 * 33、二叉搜索树的后序遍历序列
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 */
public class PostorderTraversal {


    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length <= 0) return false;
        return isTree(0, sequence.length, sequence);
    }

    public boolean isTree(int start, int end, int[] sequence) {
        if (end <= start) {
            return true;
        }
        int index;
        int last = sequence[end-1];
        for (int i = start; i < end - 1;i++) {
            index = i;
            if (sequence[i] > last) {
                for (int j = i + 1; j < end - 1;j++) {
                    if (sequence[j] < last) {
                        return false;
                    }
                }
                return isTree(start, index, sequence) && isTree(index, end - 1, sequence);
            }
        }
        return isTree(start, end - 1, sequence);
    }


    public static void main(String[] args) throws Exception{
        int[] arr = {3,7,5,12,17,15,10};
        boolean is = PostorderTraversal.class.newInstance().VerifySquenceOfBST(arr);
        System.out.println(is);
    }








}

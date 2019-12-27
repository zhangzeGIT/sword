package com.zhangze.sword;

import java.util.*;

/**
 * 7、重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class RebuildTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        List<Integer> left = new ArrayList<>();
        for (int i : pre) {
            left.add(i);
        }
        List<Integer> right = new ArrayList<>();
        for (int i : in) {
            right.add(i);
        }
        return build(left, right);
    }
    private TreeNode build(List<Integer> left, List<Integer> right) {
        TreeNode treeNode = null;
        if (left.size() <= 0) {
            return null;
        }
        treeNode = new TreeNode(left.get(0));
        List<Integer> ll = new ArrayList<>();
        List<Integer> lll = new ArrayList<>();
        List<Integer> rr = new ArrayList<>();
        List<Integer> rrr = new ArrayList<>();
        int index = right.indexOf(left.get(0));
        for (int i = 0;i < left.size();i++) {
            if (index < i) {
                rrr.add(right.get(i));
                lll.add(left.get(i));
            } else if (index > i) {
                ll.add(left.get(i+1));
                rr.add(right.get(i));
            }
        }
        treeNode.left = build(ll, rr);
        treeNode.right = build(lll, rrr);
        return treeNode;
    }

    /**
     * LeetCode上解法
     */
    private static Map<Integer, Integer> map = new HashMap<>();
    public TreeNode result(int[] pre,int[] in) {
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return build(pre, 0, pre.length - 1, 0);
    }
    public TreeNode build(int[] arr, int start, int end, int s) {
        if (start > end) {
            return null;
        }
        TreeNode treeNode = new TreeNode(arr[start]);
        int index = map.get(arr[start]);
        treeNode.left = build(arr, start + 1, start + index - s, s);
        treeNode.right = build(arr, start + index + 1 - s,end, index + 1);
        return treeNode;
    }


    public static void main(String[] args) throws Exception{
        int[] a = {1,2,4,7,3,5,6,8};
        int[] b = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = RebuildTree.class.newInstance().result(a, b);
        System.out.println(treeNode);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

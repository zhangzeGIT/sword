package com.zhangze.sword;

import java.util.Map;

/**
 * Created by zhangze on 2019/11/29
 * 55.2、平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 平衡二叉树：左右两子树之差不超过一
 *
 */
public class BalancedTree {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(depth(root.left) - depth(root.right)) <= 1) {
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }
        return false;
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    /**
     * sword推荐解法
     * 如果是上面分别遍历左右子树，那么会存在重复遍历的情况
     * 如果只遍历一次呢？就是在遍历左右子树的时候，直接判断左右子树是不是平衡二叉树
     * 记一个全局变量即可
     */
    public boolean isBalance = true;
    public boolean IsBalanced_Solution1(TreeNode root) {
        de(root);
        return isBalance;
    }
    private int de(TreeNode node) {
        if (node == null || !isBalance) return 0;
        int left = de(node.left);
        int right = de(node.right);
        if (Math.abs(left - right) > 1) isBalance = false;
        return 1 + Math.max(left, right);
    }
}

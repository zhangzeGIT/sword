package com.zhangze.sword;

/**
 * Created by zhangze on 2019/11/7
 * 27、二叉树的镜像
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class MirrorImageOfBinaryTree {

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }





}

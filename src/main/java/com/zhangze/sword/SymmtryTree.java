package com.zhangze.sword;

/**
 * Created by zhangze on 2019/11/7
 * 27、对称的二叉树
 *
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class SymmtryTree {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        if (pRoot.left != null && pRoot.right != null &&
                pRoot.left.val != pRoot.right.val) return false;
        return is(pRoot.left, pRoot.right);
    }

    boolean is(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null) return false;
        if (node2 == null) return false;
        if (node1.val == node2.val) {
            return is(node1.left, node2.right) && is(node1.right, node2.left);
        }
        return false;
    }


    public static void main(String[] args) throws Exception{
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode6l = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode8.left = treeNode6l;
        treeNode8.right = treeNode6;
        TreeNode treeNode5l = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode6l.left = treeNode5l;
        treeNode6.right = treeNode5;
        TreeNode treeNode7l = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode6l.left = treeNode7;
        treeNode6.right = treeNode7l;
        boolean b = SymmtryTree.class.newInstance().isSymmetrical(treeNode8);
        System.out.println(b);
    }






}


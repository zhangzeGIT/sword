package com.zhangze.sword;

/**
 * Created by zhangze on 2019/11/26
 * 54、二叉搜索树的第k个结点
 *
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 *
 */
public class TreeKTHLargestNode {

    private int cnt = 0;
    private TreeNode ret;

    TreeNode KthNode(TreeNode pRoot, int k) {
        k (pRoot, k);
        return ret;
    }
    void k(TreeNode pRoot, int k) {
        if (pRoot == null || cnt >= k) return;
        k (pRoot.left, k);
        cnt++;
        if (cnt == k)
            ret = pRoot;
        k (ret.right, k);
    }





    public static void main(String[] args) throws Exception{

        TreeNode treeNode = new TreeNode(8);
        TreeNode treeNode1 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(10);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(9);
        TreeNode treeNode6 = new TreeNode(11);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        TreeKTHLargestNode.class.newInstance().KthNode(treeNode, 2);


    }

}

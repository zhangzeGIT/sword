package com.zhangze.sword;

/**
 * Created by zhangze on 2019/11/11
 * 36、二叉搜索树与双向链表
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向
 *
 */
public class TreeAndLinkedList {

    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        inorder(pRootOfTree);
        return head;

    }
    // 核心思想，中序遍历，中序遍历就是按小到大的顺序
    // 中序遍历之后，只需要改变节点指向就可以了
    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = pre;
        if (pre != null) {
            pre.right = node;
        }
        pre = node;
        if (head == null) head = node;
        inorder(node.right);
    }

    public TreeNode findLeft(TreeNode node) {
        if (node == null || node.left == null) return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    public TreeNode findRight(TreeNode node) {
        if (node == null || node.right == null) return null;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }


    public static void main(String[] args) throws Exception {

    }












}

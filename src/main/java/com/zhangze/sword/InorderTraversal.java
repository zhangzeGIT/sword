package com.zhangze.sword;

import java.util.Stack;

/**
 * Created by zhangze on 2019/11/25
 *
 * 中序遍历
 * 不使用递归完成中序遍历
 * 利用栈数据结构
 */
public class InorderTraversal {


    /**
     * 对任意节点V，将V入栈，
     * 每次循环，拿出栈首元素
     * 如果栈首元素右节点不为空，加入到栈
     * 如果栈首元素左节点不为空，加入栈
     * 因为后进先出，所以再次循环，先取左节点的
     */
    public void traversal(TreeNode treeNode) {
        if (treeNode == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node .left != null) {
                stack.push(node.left);
            }
        }
    }


    public static void main(String[] args) throws Exception{

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode.left = treeNode2;
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(4);
        treeNode2.left = treeNode4;
        TreeNode treeNode5 = new TreeNode(5);
        treeNode2.right = treeNode5;
        TreeNode treeNode6 = new TreeNode(6);
        treeNode3.right = treeNode6;
        TreeNode treeNode7 = new TreeNode(7);
        treeNode6.left = treeNode7;
        TreeNode treeNode8 = new TreeNode(8);
        treeNode4.left = treeNode8;
        InorderTraversal.class.newInstance().traversal(treeNode);






    }

}

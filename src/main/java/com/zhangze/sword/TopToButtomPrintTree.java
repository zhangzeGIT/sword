package com.zhangze.sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangze on 2019/11/8
 * 32、从上到下打印二叉树
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 *
 */
public class TopToButtomPrintTree {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left !=null) {
                queue.add(node.left);
            }
            if (node.right != null) queue.add(node.right);
            res.add(node.val);
        }
        return res;
    }


















}

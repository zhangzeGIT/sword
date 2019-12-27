package com.zhangze.sword;

import java.io.Serializable;

/**
 * Created by zhangze on 2019/11/11
 * 37、序列化二叉树
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 *              从而使得内存中建立起来的二叉树可以持久保存。
 *              序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
 *              序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），
 *              以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 *
 */
public class SeriallizeTree {

    private String sss;

    String Serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val +" " + Serialize(root.left) + " " +Serialize(root.right);
    }


    TreeNode Deserialize(String str) {
        sss = str;
        return deserial();
    }

    private TreeNode deserial() {

        if (sss.length() == 0) return null;
        int index = sss.indexOf(" ");
        String node = index == -1 ? sss : sss.substring(0, index);
        sss = index == -1 ? "" : sss.substring(index + 1);
        if (node.equals("#")) {
            return null;
        }
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = deserial();
        t.right = deserial();
        return t;
    }

}

package com.zhangze.sword;

/**
 * Created by zhangze on 2019/11/7
 * 26、树的子结构
 *
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class SubOfTree {


    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2 == null) return false;
        if (root1 ==  null) return false;
        boolean isSub = isSubtree(root1, root2);
        if (isSub) return true;
        else {
            return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
    }

    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val == root2.val) {
            return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
        } else {
            return false;
        }
    }


}

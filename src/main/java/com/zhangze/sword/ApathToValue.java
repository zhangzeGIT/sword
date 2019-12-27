package com.zhangze.sword;

import java.util.ArrayList;

/**
 * TODO
 * Created by zhangze on 2019/11/8
 * 34、二叉树中和为某一值的路径 ---------------------
 *
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 */
public class ApathToValue {

    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        ArrayList<Integer> node = new ArrayList<>();
//        judge(res, node, root, 0, target);
//        if (root.left != null) {
//            res.addAll(FindPath(root.left, target));
//        }
//        if (root.right != null) {
//            res.addAll(FindPath(root.right, target));
//        }
//        return res;
        backtracking(root, target, new ArrayList<>());
        return ret;
    }

    public void judge(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> node,TreeNode root, int sum, int target) {
        if (root == null) return;
        if ((root.val + sum) == target) {
            node.add(root.val);
            for (int i = 0;i < res.size();i++) {
                if (node.size() > res.get(i).size()) {
                    res.add(i, node);
                    return;
                }
            }
            res.add(node);
            return;
        }
        if ((root.val + sum) > target) return;
        if ((root.val + sum) < target) {
            sum = sum + root.val;
            node.add(root.val);
            judge(res, node, root.left, sum, target);
            judge(res, node, root.right, sum, target);
        }
    }

    private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null) return;
        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            ret.add(new ArrayList<>(path));
        } else {
            backtracking(node.left, target, path);
            backtracking(node.right, target, path);
        }
        path.remove(path.size() - 1);
    }


}

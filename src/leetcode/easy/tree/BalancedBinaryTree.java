package leetcode.easy.tree;

import leetcode.medium.tree.TreeNode;

/**
 * Created by lenovo on 2017/9/10.
 */
public class BalancedBinaryTree {
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        getHeight(root, 1, res);
        return res;
    }

    private int getHeight(TreeNode root, int h, boolean res) {
        if(root == null) return h;
        int left = getHeight(root.left, h+1, res);
        if(!res) return h;
        int right = getHeight(root.right, h+1, res);
        if(!res) return h;
        if(Math.abs(left - right) > 1)
            res = false;
        return Math.max(left, right);
    }
}

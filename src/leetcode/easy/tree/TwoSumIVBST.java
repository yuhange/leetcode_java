package leetcode.easy.tree;

import leetcode.medium.tree.TreeNode;

import java.util.HashSet;

/**
 * Created by lenovo on 2017/9/10.
 */
public class TwoSumIVBST {
    HashSet<Integer> set = new HashSet<Integer>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        return find(root, k);
    }

    private boolean find(TreeNode root, int t) {
        if(root == null) return false;
        if(set.contains(t - root.val)) return true;
        set.add(root.val);
        return find(root.left, t) || find(root.right, t);
    }
}

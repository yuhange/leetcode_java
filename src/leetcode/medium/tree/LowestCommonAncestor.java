package leetcode.medium.tree;

/**
 * Created by lenovo on 2017/8/20.
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        if(left != null) return left;
        if(right != null) return right;
        else return null;
    }
}

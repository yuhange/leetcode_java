package leetcode.medium.tree;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 Example 1:
 2
 / \
 1   3
 Binary tree [2,1,3], return true.
 Example 2:
 1
 / \
 2   3
 Binary tree [1,2,3], return false.
 */
public class ValidBinarySearchTree {
    // 每个节点的值都被限制在一个范围内,注意Long
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long low, long high) {
        if(root.val >= high || root.val <= low) return false;
        if(root.left != null && !helper(root.left, low, root.val)) return false;
        if(root.right != null && !helper(root.right, root.val, high)) return false;
        return true;
    }
}

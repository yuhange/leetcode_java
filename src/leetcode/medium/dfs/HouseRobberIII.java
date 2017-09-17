package leetcode.medium.dfs;

import leetcode.medium.tree.TreeNode;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

 Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Example 1:
 3
 / \
 2   3
 \   \
 3   1
 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 Example 2:
 3
 / \
 4   5
 / \   \
 1   3   1
 Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        int[] dp = new int[2]; // dp[0]表示抢了当前节点;dp[1]表是没抢当前节点
        if(root == null) return dp;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        dp[0] = root.val + left[1] + right[1];
        dp[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return dp;
    }
}

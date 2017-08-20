package leetcode.medium.tree;

import java.util.*;

/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

 The root is the maximum number in the array.
 The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 Construct the maximum tree by the given array and output the root node of this tree.

 Example 1:
 Input: [3,2,1,6,0,5]
 Output: return the tree root node representing the following tree:

 6
 /   \
 3     5
 \    /
 2  0
 \
 1
 Note:
 The size of the given array will be in the range [1,1000].
 */
public class MaximumBinaryTree {
    int[][] dp;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        if(n == 0) return null;
        dp = new int[n][n];
        dp[0][0] = nums[0];
        for(int i = 0; i<n; i++) {
            map.put(nums[i], i);
            dp[i][i] = nums[i];
            for(int j = i + 1; j<n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], nums[j]);
            }
        }
        TreeNode root = dfs(0, n-1, nums);
        return root;
    }

    private TreeNode dfs(int left, int right, int[] nums) {
        if(left > right || left < 0 || right >= nums.length) return null;
        if(left == right) return new TreeNode(nums[left]);
        int max = dp[left][right];
        // System.out.println(left+" " + right + " max: "+max);
        TreeNode root = new TreeNode(max);
        root.left = dfs(left, map.get(max) - 1, nums);
        root.right = dfs(map.get(max) + 1, right, nums);
        return root;
    }
}

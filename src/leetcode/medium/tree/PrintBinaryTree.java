package leetcode.medium.tree;

import java.util.*;

/**
 * Print a binary tree in an m*n 2D string array following these rules:

 The row number m should be equal to the height of the given binary tree.
 The column number n should always be an odd number.
 The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
 Each unused space should contain an empty string "".
 Print the subtrees following the same rules.
 Example 1:
 Input:
 1
 /
 2
 Output:
 [["", "1", ""],
 ["2", "", ""]]
 Example 2:
 Input:
 1
 / \
 2   3
 \
 4
 Output:
 [["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
 Example 3:
 Input:
 1
 / \
 2   5
 /
 3
 /
 4
 Output:

 [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 Note: The height of binary tree is in the range of [1, 10].
 */
public class PrintBinaryTree {
    int height = 0;
    public List<List<String>> printTree(TreeNode root) {
        height = getHeight(root);
        // System.out.println(height);
        int col = get2N(height) - 1;
        String[][] m = new String[height][col];
        for(int i = 0; i<height; i++) {
            for(int j = 0; j<col; j++) {
                m[i][j] = new String("");
            }
        }
        dfs(root, 0, col, m, height);
        List<List<String>> res = new ArrayList<List<String>>();
        for(int i = 0; i<height; i++) {
            res.add(Arrays.asList(m[i]));
        }
        return res;
    }

    private void dfs(TreeNode root, int left, int right, String[][] m, int h) {
        if(root == null || h < 0) return;
        int mid = left + (right - left) / 2;
        m[height - h][mid] = root.val + "";
        dfs(root.left, left, mid - 1, m, h - 1);
        dfs(root.right, mid + 1, right, m, h - 1);
    }

    private int getHeight(TreeNode root) {
        if(root == null) return 0;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        return Math.max(l, r) + 1;
    }

    private int get2N(int height) {
        int res = 1;
        while(height > 0) {
            res = res * 2;
            height --;
        }
        return res;
    }
}

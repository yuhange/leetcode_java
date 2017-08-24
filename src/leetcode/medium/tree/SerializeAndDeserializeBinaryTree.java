package leetcode.medium.tree;

import java.util.*;

/**
 * Created by lenovo on 2017/8/24.
 */
public class SerializeAndDeserializeBinaryTree {
    private TreeNode deserialize(LinkedList<String> list) {
        String cur = list.poll();
        if(cur.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#!";
        String res = root.val + "!";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ss = data.split("!");
        LinkedList<String> list = new LinkedList<String>();
        for(int i = 0; i<ss.length; i++) {
            list.offer(ss[i]);
        }
        return deserialize(list);
    }
}

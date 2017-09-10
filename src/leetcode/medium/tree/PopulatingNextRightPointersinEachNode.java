package leetcode.medium.tree;

import java.util.LinkedList;

/**
 * Created by lenovo on 2017/9/10.
 */
public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        LinkedList<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            int n = q.size();
            TreeLinkNode pre = q.poll();
            if(pre.left != null) q.offer(pre.left);
            if(pre.right != null) q.offer(pre.right);
            System.out.println("pre: " + pre.val);
            TreeLinkNode t;
            for(int i = 1; i<n; i++) {
                t = q.poll();
                if(t.left != null) q.offer(t.left);
                if(t.right != null) q.offer(t.right);
                System.out.println("t: " + t.val);
                pre.next = t;
                pre = t;
            }
            pre.next = null;
        }
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersinEachNode p = new PopulatingNextRightPointersinEachNode();
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(2);
        p.connect(root);
    }
}

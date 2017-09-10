package leetcode.medium.tree;

import java.util.LinkedList;

/**
 * Created by lenovo on 2017/9/10.
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        LinkedList<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            int n = q.size();
            TreeLinkNode pre = q.poll();
            if(pre.left != null) q.offer(pre.left);
            if(pre.right != null) q.offer(pre.right);
            TreeLinkNode t = null;
            for(int i = 1; i<n; i++) {
                t = q.poll();
                pre.next = t;
                pre = t;
                if(t.left != null) q.offer(t.left);
                if(t.right != null) q.offer(t.right);
            }
            pre.next = null;
        }
    }
}

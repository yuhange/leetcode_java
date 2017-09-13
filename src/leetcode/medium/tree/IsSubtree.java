package leetcode.medium.tree;

/**
 * Created by lenovo on 2017/9/13.
 */
public class IsSubtree {
    public boolean containsTree(TreeNode t1, TreeNode t2) {
        boolean flag = false;
        if(t2 == null) return true;
        if(t1 != null) {
            flag = isSameTree(t1, t2);
            if(!flag) {
                flag = containsTree(t1.left, t2);
                if(!flag) {
                    flag = containsTree(t1.right, t2);
                }
            }
        }
        return flag;
    }

    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.val ==)
    }
}

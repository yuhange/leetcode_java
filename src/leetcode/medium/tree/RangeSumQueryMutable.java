package leetcode.medium.tree;

/**
 * Created by lenovo on 2017/9/17.
 */
public class RangeSumQueryMutable {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5};
        NumArray n = new NumArray(nums);
        System.out.println(n.sumRange(2, 4));
        n.update(3, 3);
        System.out.println(n.sumRange(2, 4));
    }
}

class NumArray {

    SegmentTreeNode root;

    public NumArray(int[] nums) {
        root = build(nums);
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    private void update(SegmentTreeNode root, int i, int val){
        if(root == null) return;
        int s = root.start;
        int e = root.end;
        if(i == s && i == e) root.sum = val;
        else {
            int mid = s + (e - s) / 2;
            if(mid >= i) update(root.left, i, val);
            else update(root.right, i, val);
            root.sum = root.left.sum + root.right.sum;
        }
    }
    public int sumRange(int i, int j) {
        return query(root, i, j);
    }

    private int query(SegmentTreeNode root, int i, int j) {
        if (root == null) return 0;
        if (root.start == i && root.end == j) return root.sum;
        int s = root.start;
        int e = root.end;
        int mid = s + (e - s) / 2;
        if (j <= mid) return query(root.left, i, j);
        if (i > mid) return query(root.right, i, j);
        else return query(root.left, i, mid) + query(root.right, mid + 1, j);
    }

    private SegmentTreeNode build(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode build(int[] nums, int l, int r) {
        if (l > r) return null;
        SegmentTreeNode root = new SegmentTreeNode(l, r);
        if (l == r) root.sum = nums[l];
        else {
            int mid = l + (r - l) / 2;
            root.left = build(nums, l, mid);
            root.right = build(nums, mid + 1, r);
            root.sum = root.left.sum + root.right.sum;
        }
        return root;
    }
}

class SegmentTreeNode {
    int sum, start, end;
    SegmentTreeNode left;
    SegmentTreeNode right;

    public SegmentTreeNode(int start, int end) {
        this.sum = 0;
        this.start = start;
        this.end = end;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
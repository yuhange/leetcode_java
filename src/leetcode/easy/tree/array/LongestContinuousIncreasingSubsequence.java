package leetcode.easy.tree.array;

/**
 * Created by lenovo on 2017/9/10.
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null) return 0;
        int n = nums.length;
        int len = 1;
        int max = 0;
        for(int i = 1; i<n; i++) {
            if(nums[i] > nums[i-1]) {
                len ++;
            } else {
                len = 1;
            }
            max = Math.max(len, max);
        }
        return max;
    }
}

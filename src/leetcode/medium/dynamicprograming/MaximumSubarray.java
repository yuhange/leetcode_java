package leetcode.medium.dynamicprograming;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++) {
            if(sum >= 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}

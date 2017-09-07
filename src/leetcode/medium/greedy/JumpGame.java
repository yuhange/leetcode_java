package leetcode.medium.greedy;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums == null) return true;
        int n = nums.length;
        int maxJump = 0;
        for(int i = 0; i<n && i<=maxJump; i++) {
            maxJump = Math.max(maxJump, nums[i] + i);
        }
        if(maxJump < n - 1) return false;
        return true;
    }
}

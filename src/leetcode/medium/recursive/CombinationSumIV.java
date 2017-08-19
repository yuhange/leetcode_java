package leetcode.medium.recursive;

/**
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

 Example:

 nums = [1, 2, 3]
 target = 4

 The possible combination ways are:
 (1, 1, 1, 1)
 (1, 1, 2)
 (1, 2, 1)
 (1, 3)
 (2, 1, 1)
 (2, 2)
 (3, 1)

 Note that different sequences are counted as different combinations.

 Therefore the output is 7.
 */
public class CombinationSumIV {
    // 会超时
    int res = 0;
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        dfs(target, nums);
        return res;
    }

    private void dfs(int target, int[] nums) {
        if(target == 0) {
            res ++;
            return;
        }
        if(target < 0) return;
        for(int i = 0; i<nums.length; i++) {
            dfs(target - nums[i], nums);
        }
    }
}

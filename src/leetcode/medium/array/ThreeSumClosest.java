package leetcode.medium.array;

import java.util.*;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if(n <= 2) return 0;
        Arrays.sort(nums);
        int minGap = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // for(int i = 0; i<n; i++) map.put(nums[i], i);
        for(int i = 0; i<n; i++) {
            int cur = target - nums[i];
            int j = i + 1;
            int k = n - 1;
            while(j < k) {
                if(Math.abs(nums[i] + nums[j] + nums[k] - target) < minGap) {
                    minGap = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    minSum = nums[i] + nums[j] + nums[k];
                }
                if(nums[j] + nums[k] == cur) return target;
                else if(nums[j] + nums[k] < cur) j ++;
                else k --;
            }
        }
        return minSum;
    }
}

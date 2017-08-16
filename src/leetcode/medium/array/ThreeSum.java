package leetcode.medium.array;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n <= 2) return res;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Arrays.sort(nums);
        for(int i = 0; i<n; i++) map.put(nums[i], i);
        for(int i = 0; i<n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int target = 0 - nums[i];
            // 用二分法替换
            // for(int j = i + 1; j<n; j++) {
            //     if(map.containsKey(target - nums[j]) && map.get(target - nums[j]) > j) {
            //         res.add(Arrays.asList(nums[i], nums[j], target-nums[j]));
            //     }
            // }
            int j = i + 1;
            int k = n - 1;
            while(j < k) {
                if(nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j ++;
                    k --;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(k > j && nums[k] == nums[k+1]) k--;
                }
                else if(nums[j] + nums[k] < target) j ++;
                else k --;
            }
        }
        return res;
    }
}

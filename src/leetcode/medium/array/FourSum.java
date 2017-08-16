package leetcode.medium.array;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note: The solution set must not contain duplicate quadruplets.

 For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // for(int i = 0; i<n; i++) map.put(nums[i], i);
        for(int i = 0; i<n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1; j<n; j++) {
                if(nums[j] == nums[j - 1]) continue;
                // for(int k = j + 1; k<n; k++) {
                //     if(map.containsKey(target - nums[i] - nums[j] - nums[k]) && map.get(target - nums[i] - nums[j] - nums[k])>k) {
                //         res.add(Arrays.asList(nums[i], nums[j], nums[k], target - nums[i] - nums[j] - nums[k]));
                //     }
                // }
                int curT = target - nums[i] - nums[j];
                int k = j + 1;
                int     m = n - 1;
                        while(k < m) {
                            if(nums[k] + nums[m] == curT) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                                while(k<m && nums[k] == nums[k+1]) k++;
                                while(k<m && nums[m] == nums[m-1]) m--;
                        k ++;
                        m --;
                    } else if(nums[k] + nums[m] < curT) k ++;
                    else m --;
                }
            }
        }
        return res;
    }
}

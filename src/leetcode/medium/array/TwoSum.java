package leetcode.medium.array;

import java.util.*;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].

 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i<n; i++) {
            map.put(nums[i], i);
        }
        int[] res = {-1, -1};

        for(int i = 0; i<n; i++) {
            if(map.containsKey(target - nums[i])) {
                if(map.get(target - nums[i]) > i) {
                    res[0] = i;
                    res[1] = map.get(target - nums[i]);
                    return res;
                }
            }
        }
        return res;
    }
}

package leetcode.medium.recursive;

import java.util.*;

/**
 * Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class Subset {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        if(n == 0) return res;
        dfs(0, nums, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int start, int[] nums, List<Integer> list) {
        if(list.size() <= nums.length) {
            res.add(new ArrayList(list));
        }
        if(list.size() > nums.length) return;
        for(int i = start; i<nums.length; i++) {
            list.add(nums[i]);
            dfs(i+1, nums, list);
            list.remove(list.size()-1);
        }
    }
}


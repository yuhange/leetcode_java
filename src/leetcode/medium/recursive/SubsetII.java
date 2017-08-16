package leetcode.medium.recursive;

import java.util.*;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class SubsetII {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        if(n == 0) return res;
        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int start, int[] nums, List<Integer> list) {
        if(list.size() <= nums.length) {
            res.add(new ArrayList(list));
        }
        if(list.size() > nums.length) return;
        for(int i = start; i<nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            dfs(i+1, nums, list);
            list.remove(list.size()-1);
        }
    }
}

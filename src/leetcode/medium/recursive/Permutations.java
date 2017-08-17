package leetcode.medium.recursive;

import java.util.*;

/**
 * Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
public class Permutations {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    HashSet<Integer> v = new HashSet<Integer>();
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        if(n == 0) return res;

        dfs(nums, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int[] nums, ArrayList<Integer> list) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i<nums.length; i++) {
            if(v.contains(nums[i])) continue;
            list.add(nums[i]);
            v.add(nums[i]);
            dfs(nums, list);
            list.remove(list.size() - 1);
            v.remove(nums[i]);
        }
    }
}

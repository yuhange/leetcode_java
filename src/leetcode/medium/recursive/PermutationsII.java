package leetcode.medium.recursive;

import java.util.*;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 */
public class PermutationsII {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    boolean[] v;
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        if(n == 0) return res;
        Arrays.sort(nums);
        v = new boolean[n];
        dfs(nums, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int[] nums, ArrayList<Integer> list) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i<nums.length; i++) {
            if(i > 0 && !v[i - 1] && nums[i] == nums[i - 1]) continue;
            if(v[i] == false) {
                list.add(nums[i]);
                v[i] = true;
                dfs(nums, list);
                list.remove(list.size() - 1);
                v[i] = false;
            }
        }
    }
}

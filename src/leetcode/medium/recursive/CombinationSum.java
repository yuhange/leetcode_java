package leetcode.medium.recursive;

import java.util.*;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]
 */
public class CombinationSum {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        if(n == 0) return res;
        Arrays.sort(candidates);
        dfs(0, 0, candidates, target, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int start, int sum, int[] cand, int target, List<Integer> list) {
        if(sum > target) return;
        if(sum == target) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = start; i<cand.length; i++) {
            list.add(cand[i]);
            dfs(i, sum + cand[i], cand, target, list);
            list.remove(list.size() - 1);
        }
    }
}

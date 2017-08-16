package leetcode.medium.recursive;

import java.util.*;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]

 */
public class CombinationSumII {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if( (i > start && cand[i] == cand[i-1])) continue;
            list.add(cand[i]);
            dfs(i + 1, sum + cand[i], cand, target, list);
            list.remove(list.size() - 1);
        }
    }
}

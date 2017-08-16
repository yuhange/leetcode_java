package leetcode.medium.recursive;

import java.util.*;

/**
 * Created by lenovo on 2017/8/16.
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
            res.add(new ArrayList<>(list));
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

package leetcode.medium.recursive;

import java.util.*;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class Combinations {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        if(n == 0) return res;
        dfs(0, 1, n, k, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int pos, int start, int n, int k, ArrayList<Integer> list) {
        if(list.size() > k) return;
        if(list.size() == k) res.add(new ArrayList<Integer>(list));
        for(int i = start; i <= n; i++) {
            list.add(i);
            dfs(pos + 1, i + 1, n, k, list);
            list.remove(list.size() - 1);
        }
    }
}

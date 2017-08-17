package leetcode.medium.recursive;

import java.util.*;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]

 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    boolean[] v = new boolean[10];
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k == 0 || n == 0) return res;
        dfs(1, 0, k, n, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int start, int sum, int k, int n, List<Integer> list) {
        if(list.size() == k && sum == n) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if(list.size() > k || sum > n) return;
        for(int i = start; i<=9; i++) {
            if(v[i] == true) continue;
            list.add(i);
            v[i] = true;
            dfs(i+1, sum + i, k, n, list);
            list.remove(list.size() - 1);
            v[i] = false;
        }
    }
}

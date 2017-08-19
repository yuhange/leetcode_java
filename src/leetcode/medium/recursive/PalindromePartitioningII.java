package leetcode.medium.recursive;

import java.util.*;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return the minimum cuts needed for a palindrome partitioning of s.

 For example, given s = "aab",
 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioningII {
    // 会超时
    int min = Integer.MAX_VALUE;
    public int minCut(String s) {
        int n = s.length();
        if(n == 0) return 0;
        if(n == 1) return 0;
        if(isP(s)) return 0;
        dfs(s, new ArrayList<String>());
        if(min == Integer.MAX_VALUE) return 0;
        return min - 1;
//        return cnt - 1;
    }

    private void dfs(String s, ArrayList<String> list) {
        if(s.length() == 0) {
            // res.add(new ArrayList<String>(list));
            // for(String t: list) System.out.print(t+" ");
            // System.out.println();
            min = Math.min(min, list.size());
            return;
        }
        for(int i = 1; i <= s.length(); i ++) {
            if(isP(s.substring(0, i))) {
                list.add(s.substring(0, i));
                dfs(s.substring(i), list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isP(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i ++;
                j --;
            } else return false;
        }
        return true;
    }
}

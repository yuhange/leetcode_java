package leetcode.medium.recursive;

import java.util.*;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
public class PalindromePartitioning {
    List<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        int n = s.length();
        if(n == 0) return res;
        dfs(s, new ArrayList<String>());
        return res;
    }

    private void dfs(String s, ArrayList<String> list) {
        if(s.length() == 0) {
            res.add(new ArrayList<String>(list));
            return;
        }
        for(int i = 1; i<=s.length(); i++) {
            String tmp = s.substring(0, i);
            if(isP(tmp)) {
                list.add(tmp);
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

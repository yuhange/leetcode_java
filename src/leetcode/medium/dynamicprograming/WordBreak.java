package leetcode.medium.dynamicprograming;

import java.util.*;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        if(n == 0) return false;
        boolean[] dp = new boolean[n];
        dp[0] = wordDict.contains(s.substring(0, 1));
        for(int i = 1; i<n; i++) {
            boolean hasTrue = false;
            int j = i - 1;
            for(; j>=0; j--) {
                if(dp[j] == true && wordDict.contains(s.substring(j+1, i+1))) {
                    hasTrue = true;
                }
            }
            if(hasTrue || wordDict.contains(s.substring(0, i+1))) dp[i] = true;
        }
        return dp[n - 1];
    }
}

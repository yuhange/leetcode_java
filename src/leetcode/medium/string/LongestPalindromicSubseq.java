package leetcode.medium.string;

/**
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

 Example 1:
 Input:

 "bbbab"
 Output:
 4
 One possible longest palindromic subsequence is "bbbb".
 Example 2:
 Input:

 "cbbd"
 Output:
 2
 One possible longest palindromic subsequence is "bb".
 */
public class LongestPalindromicSubseq {
    public int longestPalindromeSubseq(String s) {
        int max = 0;
        int n = s.length();
        if(n <= 1) return n;
        int[][] dp = new int[n][n];
        for(int i = n - 1; i>=0; i--) {
            for(int j = i; j<n; j++) {
                if(i == j) dp[i][j] = 1;
                else if(j - i == 1) dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
                else {
                    if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1] + 2;
                    else dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}

package leetcode.medium.string;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.

 The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

 Example 1:
 Input: "abc"
 Output: 3
 Explanation: Three palindromic strings: "a", "b", "c".
 Example 2:
 Input: "aaa"
 Output: 6
 Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 Note:
 The input string length won't exceed 1000.
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int cnt = 0;
        int n = s.length();
        if(n <= 1) return n;
        boolean[][] dp = new boolean[n][n];
        for(int i = n - 1; i>=0; i--) {
            for(int j = i; j<n; j++) {
                if(i == j) dp[i][j] = true;
                else if(j - i == 1) dp[i][j] = s.charAt(i) == s.charAt(j);
                else {
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                }
                if(dp[i][j] == true) cnt ++;
            }
        }
        return cnt;
    }
}

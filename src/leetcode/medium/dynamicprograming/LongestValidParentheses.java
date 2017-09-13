package leetcode.medium.dynamicprograming;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null) return 0;
        int n = s.length();
        if (n <= 1) return 0;
        char[] c = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = false;
            for (int j = i; j < n; j++) {
                // System.out.println(i + " " + j);
                if (j == (i + 1)) dp[i][j] = (c[i] == '(' && c[j] == ')');
                else if ((j - i) % 2 == 0) dp[i][j] = false;
                else {
                    dp[i][j] = (c[i] == '(' && c[j] == ')' && dp[i + 1][j - 1] == true);
                    if (dp[i][j] == false) {
                        for (int k = i; k <= j; k++) {
                            if (dp[i][k] == true && dp[k + 1][j] == true) {
                                dp[i][j] = true;
                                break;
                            }
                        }
                    }
                }
                if (dp[i][j] == true) max = Math.max(max, (j - i + 1));
            }
        }
        return max;
    }
}

package leetcode.medium.dynamicprograming;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s == null) return 0;
        int n = s.length();
        if(n <= 1) return 0;
        char[] c = s.toCharArray();
        int[] dp = new int[n];
        dp[0] = 0;
        int max = 0;
        for(int i = 1; i<n; i++) {
            if(c[i] == ')') {
                if(c[i-1] == '(') {
                    dp[i] = ((i - 2) >= 0 ? dp[i-2] : 0) + 2;
                } else if(c[i-1] == ')') {
                    if(i - dp[i-1] - 1 >= 0 && c[i - dp[i-1] - 1] == '(')
                        dp[i] = dp[i-1] + 2 + ((i - dp[i-1] - 2) >= 0 ? dp[i - dp[i-1] - 2] : 0);
                }
                max = Math.max(max, dp[i]);
            }
        }
        // for(int i = 0; i<n; i++) {
        //     for(int j = 0; j<n; j++) {
        //         if(dp[i][j] == true) System.out.println(i + " " + j);
        //     }
        // }
        return max;
    }
}

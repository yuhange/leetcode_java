package leetcode.medium.string;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.
 Example:

 Input: "cbbd"

 Output: "bb"
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n <= 1) return s;
        char[] cc = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        String res = "";
        dp[n-1][n-1] = true;
        for(int i = n - 1 ; i>=0; i--) {
            for(int j = i; j<n; j++) {
                dp[i][j] = (cc[i] == cc[j]) && (j - i < 3 || dp[i+1][j-1]);
                if(dp[i][j]  && (res == null || j-i+1 > res.length())) {
                    res = s.substring(i, j+1);
                }
            }
        }
        return res;
    }

    public String center(String s) {
        int n = s.length();
        if(n <= 1) return s;
        String res = s.substring(0, 1);
        for(int i = 0; i<n; i++) {
            String tmp = isPalindromic(s, i, i);
            if(tmp.length() > res.length()) res = tmp;
            tmp = isPalindromic(s, i, i+1);
            if(tmp.length() > res.length()) res = tmp;
        }
        return res;
    }

    private String isPalindromic(String s, int i, int j) {
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)) {
            i --;
            j ++;
        }
        return s.substring(i+1, j);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.center("ababa"));
    }
}

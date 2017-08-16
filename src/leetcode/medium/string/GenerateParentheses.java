package leetcode.medium.string;

import java.util.*;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class GenerateParentheses {
    List<String> res = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        if(n < 0) return res;
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String s) {
        if(right < left) return;
        if(left == 0 && right == 0) res.add(s);
        if(left > 0) dfs(left - 1, right, s + "(");
        if(right > 0) dfs(left, right - 1, s + ")");
    }
}

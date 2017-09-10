package leetcode.medium.dynamicprograming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

 Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.

 Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.

 Example 1:
 Input: [[1,2], [2,3], [3,4]]
 Output: 2
 Explanation: The longest chain is [1,2] -> [3,4]
 */
public class MaximumLengthofPairChain {
    public int findLongestChain(int[][] pairs) {
        if(pairs == null) return 0;
        int n = pairs.length;
        if(n <= 1) return n;
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] dp = new int[n];
        int max = 0;
        for(int i = 0; i<n; i++) {
            dp[i] = 1;
            for(int j = 0; j<i; j++) {
                if(pairs[i][0] > pairs[j][1] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

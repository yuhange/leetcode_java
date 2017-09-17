package leetcode.medium.dynamicprograming;

/**
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

 What is the maximum number of envelopes can you Russian doll? (put one inside other)

 Example:
 Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
import java.util.*;
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        // 边界判定
        // 边界判定
        if(envelopes == null) return 0;
        int n = envelopes.length;
        if(n == 0) return 0;
        if(envelopes[0].length != 2) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });

        int[] dp = new int[n];
        int max = 0;
        for(int i = 0; i<n; i++) {
            dp[i] = 1;
            for(int j = 0; j<=i; j++) {
                if(dp[j] > dp[i] - 1 && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

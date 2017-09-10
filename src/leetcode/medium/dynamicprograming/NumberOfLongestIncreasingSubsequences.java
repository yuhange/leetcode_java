package leetcode.medium.dynamicprograming;

/**
 * Given an unsorted array of integers, find the number of longest increasing subsequence.

 Example 1:
 Input: [1,3,5,4,7]
 Output: 2
 Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 Example 2:
 Input: [2,2,2,2,2]
 Output: 5
 Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1,
 */
import java.util.*;
public class NumberOfLongestIncreasingSubsequences {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null) return 0;
        int n = nums.length;
        if (n <= 1) return n;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        int max = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                // 主要是这一部分和普通的LIS不同
                if (nums[j] < nums[i]) {
                    if(dp[j] > dp[i] - 1) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if(dp[i] == dp[j] + 1) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if(max == dp[i]) {
                res += cnt[i];
            }
            if(max < dp[i]) {
                max = dp[i];
                res = cnt[i];
            }
        }
        return res;
    }
//    List<List<Integer>> res = new ArrayList<List<Integer>>();
//    public int findNumberOfLIS(int[] nums) {
//        if (nums == null) return 0;
//        int n = nums.length;
//        if (n <= 1) return n;
//        for(int i = 0; i<n; i++) {
//            List<Integer> list = new ArrayList<Integer>();
//            list.add(nums[i]);
//            dfs(nums, i, list);
////            System.out.println(count);
//        }
//        for(List<Integer> list: res) {
//            for(int i: list) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
//        return 3;
//    }
//
//    private void dfs(int[] p, int start, List<Integer> list) {
////        System.out.println(start);
//        if(start == p.length - 1) {
//            res.add(new ArrayList<Integer>(list));
//            return;
//        }
//        for(int i = start; i<p.length; i++) {
//            if(i != start && p[i] > p[start]) {
//                list.add(p[i]);
//                dfs(p, i, list);
//                list.remove(list.size() - 1);
//            }
//        }
//    }
    public static void main(String[] args) {
        NumberOfLongestIncreasingSubsequences n = new NumberOfLongestIncreasingSubsequences();
        int[] p = {2,2,2,2,2};
        System.out.println(n.findNumberOfLIS(p));
    }
}
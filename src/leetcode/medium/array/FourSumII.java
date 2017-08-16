package leetcode.medium.array;

import java.util.*;

/**
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

 To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

 Example:

 Input:
 A = [ 1, 2]
 B = [-2,-1]
 C = [-1, 2]
 D = [ 0, 2]

 Output:
 2

 Explanation:
 The two tuples are:
 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        if(len == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i: A) {
            for(int j: B) {
                if(map.containsKey(i + j) == true) map.put(i + j, map.get(i+j) + 1);
                else map.put(i + j, 1);
            }
        }

        int cnt = 0;
        for(int i: C) {
            for(int j: D) {
                if(map.containsKey(0 - i - j)) {
                    cnt += map.get(0 - i - j);
                }
            }
        }
        return cnt;
    }
}

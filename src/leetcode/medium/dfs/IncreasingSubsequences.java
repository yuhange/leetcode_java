package leetcode.medium.dfs;

import leetcode.medium.dynamicprograming.IncreasingTripletSubsequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .

 Example:
 Input: [4, 6, 7, 7]
 Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 Note:
 The length of the given array will not exceed 15.
 The range of integer in the given array is [-100,100].
 The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 */
public class IncreasingSubsequences {
    HashSet<List<Integer>> res = new HashSet<List<Integer>>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null) return result;
        int n = nums.length;
        if (n <= 0) return result;
        for(int i = 0; i<n; i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[i]);
            dfs(nums, i, list);
        }
        for(List<Integer> list: res) {
            result.add(list);
            for(int i: list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        return result;
    }

    private void dfs(int[] p, int start, List<Integer> list) {
//        System.out.println(start);
//        if(start == p.length - 1) {
        if(list.size() >= 2) {
            res.add(new ArrayList<Integer>(list));
//            retu/rn;
        }
//        }
        for(int i = start; i<p.length; i++) {
            if(i != start && p[i] >= p[start]) {
                list.add(p[i]);
                dfs(p, i, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        IncreasingSubsequences s = new IncreasingSubsequences();
        int[] p = {4,6,7,7};
        s.findSubsequences(p);
    }
}
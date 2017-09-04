package leetcode.hard;
import java.util.*;
/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Therefore, return the max sliding window as [3,3,5,5,6,7].

 Note:
 You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

 Follow up:
 Could you solve it in linear time?
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || n < k) return new int[0];
        int[] res = new int[n - k + 1];
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i<n; i++) {
            while(!list.isEmpty() && nums[i] >= nums[list.getLast()]) list.removeLast();
            list.addLast(i);
            if(i - list.getFirst() + 1 > k) list.removeFirst();
            if(i + 1 >= k) res[i - k + 1] = nums[list.getFirst()];
        }
        return res;
    }
}

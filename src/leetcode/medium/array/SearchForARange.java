package leetcode.medium.array;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int n = nums.length;
        if(n == 0) return res;
        int i = 0;
        int j = n - 1;
        while(i <= j) {
            int mid = i + (j - i) / 2;
            if(nums[mid] == target) {
                int tmp;
                for(tmp = mid; tmp >= 0 && nums[tmp] == target; tmp --) {}
                res[0] = tmp + 1;
                for(tmp = mid; tmp < n && nums[tmp] == target; tmp ++) {}
                res[1] = tmp - 1;
                return res;
            } else if(nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return res;
    }
}

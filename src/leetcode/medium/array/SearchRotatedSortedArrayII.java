package leetcode.medium.array;

/**
 * Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Write a function to determine if a given target is in the array.

 The array may contain duplicates.
 */
public class SearchRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return false;
        int i = 0;
        int j = n - 1;
        while(i + 1 < j) {
            int mid = i + (j - i) / 2;
            if(nums[mid] == target) return true;
            if(nums[mid] > nums[i]) {
                if(target >= nums[i] && target <= nums[mid]) j = mid;
                else i = mid;
            } else if(nums[mid] < nums[i]){
                if(target >= nums[mid] && target <= nums[j]) i = mid;
                else j = mid;
            }
            else i ++;
        }
        if(nums[i] == target || nums[j] == target) return true;
        return false;
    }
}

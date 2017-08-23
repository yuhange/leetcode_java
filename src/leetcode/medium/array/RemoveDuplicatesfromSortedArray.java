package leetcode.medium.array;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 0) return n;
        int l = 0;
        for(int r = 1; r<n; r ++) {
            if(nums[r] != nums[l]) {
                nums[++l] = nums[r];
            }
        }
        return l + 1;
    }
}

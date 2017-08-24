package leetcode.medium.array;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if(n <= 1) return nums;
        int[] res = new int[n];
        res[n - 1] = 1;
        for(int i = n - 2; i>=0; i--) {
            res[i] = res[i+1] * nums[i+1];
        }
        int left = 1;
        for(int i = 1; i<n; i++) {
            left *= nums[i-1];
            res[i] *= left;
        }
        return res;
    }
}

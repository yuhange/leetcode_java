package leetcode.medium.array;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n <= 1) return;
        if(n == 2) {
            revert(nums, 0, 1);
            return;
        }
        int index = n - 1;
        // 从右向左遍历，寻找第一个破坏严格递增的节点。
        for(; index>=1; index--) {
            if(nums[index] > nums[index - 1]) break;
        }
        if(index == 0) {
            revert(nums, 0, n-1);
            return;
        }
        if(index == n - 1) {
            revert(nums, index - 1, index);
            return;
        }
        int i = index;
        index --;
        for(; i<n; i++) {
            if(nums[i] <= nums[index]) break;
        }
        i --;
        swap(i, index, nums);
        revert(nums, index+1, n-1);
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void revert(int[] nums, int i, int j) {
        while(i < j) {
            swap(i, j, nums);
            i ++;
            j --;
        }
    }
}

package leetcode.medium.array;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example:
 Given input array nums = [3,2,2,3], val = 3

 Your function should return length = 2, with the first two elements of nums being 2.


 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1 && nums[0] == val) return 0;
        if(n == 1 && nums[0] != val) return 1;
        int i = 0;
        int j = n - 1;
        while(i < j) {
            while(i < j && nums[i] != val) i ++;
            while(i < j && nums[j] == val) j --;
            if(nums[i] != nums[j]) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        int res = n;
        while(res > 0 && nums[res - 1] == val) res --;
        return res;
    }

    public int removeElement2(int[] nums, int val) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1 && nums[0] == val) return 0;
        if(n == 1 && nums[0] != val) return 1;
        int j = 0;
        for(int i = 0; i<n; i++) {
            if(nums[i] != val) nums[j ++] = nums[i];
        }
        return j;
    }
}

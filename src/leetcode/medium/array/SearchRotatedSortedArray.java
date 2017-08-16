package leetcode.medium.array;

/**
 * Created by lenovo on 2017/8/16.
 */
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return -1;
        int i = 0;
        int j = n - 1;
        while(i + 1 < j) {
            int mid = i + (j - i) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > nums[i]) {
                //分三种情况
                if(target >= nums[i] && target <= nums[mid]) j = mid;
                else i = mid;
            } else {
                if(target >= nums[mid] && target <= nums[j]) i = mid;
                else j = mid;
            }
        }
        if(nums[i] == target) return i;
        if(nums[j] == target) return j;
        return -1;
    }
}

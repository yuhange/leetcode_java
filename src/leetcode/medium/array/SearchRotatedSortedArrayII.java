package leetcode.medium.array;

/**
 * Created by lenovo on 2017/8/16.
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

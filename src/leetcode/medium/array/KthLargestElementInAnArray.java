package leetcode.medium.array;

/**
 * Created by lenovo on 2017/8/24.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return -1;
        int i = 0;
        int j = n - 1;
        while(i <= j) {
            int pivot = partition(nums, i, j);
            // System.out.println(pivot);
            if(pivot == n - k) return nums[pivot];
            else if(pivot < n - k) i = pivot + 1;
            else j = pivot - 1;
        }
        return -1;
    }

    private int partition(int[] nums, int i, int j) {
        int pivot = nums[i];
        while(i < j) {
            while(i < j && nums[j] >= pivot) j --;
            if(i < j) nums[i ++] = nums[j];
            while(i < j && nums[i] <= pivot) i ++;
            if(i < j) nums[j --] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }
}

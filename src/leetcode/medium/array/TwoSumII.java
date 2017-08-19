package leetcode.medium.array;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution and you may not use the same element twice.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] res = {-1, -1};
        if(n <= 1) return res;
        int i = 0;
        int j = n - 1;
        while(i < j) {
            int tmp = numbers[i] + numbers[j];
            if(tmp == target) {
                res[0] = i + 1;
                res[1] = j + 1;
                return res;
            } else if(tmp < target) {
                i ++;
            } else {
                j --;
            }
        }
        return res;
    }
}

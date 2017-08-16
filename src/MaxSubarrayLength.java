/**
 * Created by lenovo on 2017/3/20.
 */
public class MaxSubarrayLength {
    public static int maxLength(int a[], int k) {
        int max = 0;
        int i = 0;
        int j = 0;
        int sum = 0;
        while(i<a.length && j<a.length) {
            if(sum + a[j] < k) {
                sum += a[j++];
            } else if(sum + a[j] == k) {
                max = Math.max(max, j-i+1);
                sum = 0;
                i = j+1;
                j = i;
            } else {
                sum -= a[i++];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int a[] = {1,2,1,1,1};
        System.out.println(maxLength(a, 3));
    }
}

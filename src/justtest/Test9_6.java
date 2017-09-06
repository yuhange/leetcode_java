package justtest;

/**
 * Created by lenovo on 2017/9/6.
 */
public class Test9_6 {
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0) return 0;
        int n = array.length;
        int left = getLower(array, k, n);
        int right = getHigher(array, k, n);
        if(left != -1 && right != -1)
            return right - left + 1;
        return 0;
    }

    private int getLower(int[] array, int k, int n) {
        int i = 0;
        int j = n - 1;
        int mid;
        while(i <= j) {
            mid = i + (j - i) / 2;
            if(array[mid] < k) i = mid + 1;
            else if(array[mid] > k) j = mid - 1;
            else if(mid - 1 >= 0 && array[mid - 1] == k) j = mid - 1;
            else return mid;
        }
        return -1;
    }

    private int getHigher(int[] array, int k, int n) {
        int i = 0;
        int j = n - 1;
        int mid;
        while(i <= j) {
            mid = i + (j - i) / 2;
            if(array[mid] < k) i = mid + 1;
            else if(array[mid] > k) j = mid - 1;
            else if(mid + 1 < n && array[mid + 1] == k) i = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        Test9_6 test = new Test9_6();
        int[] n = {1,1,2,3,4,5,5,5,6,7,7};
        System.out.println(test.GetNumberOfK(n, 4));
    }
}

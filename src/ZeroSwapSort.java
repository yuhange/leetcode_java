/**
 * Created by lenovo on 2017/3/17.
 */
public class ZeroSwapSort {
    static int[] arr = {0,3,7,5,4,1,6,2};
    public static void swapWithZero(int[] arr, int len, int n) {
        int index0 = 0;
        int indexN = 0;
        for(int i = 0; i<len; i++) {
            if(arr[i] == n) indexN = i;
            if(arr[i] == 0) index0 = i;
        }
        int tmp = arr[index0];
        arr[index0] = arr[indexN];
        arr[indexN] = tmp;
    }

    public static void sort(int[] arr, int len) {
        if(arr[0] != 0) swapWithZero(arr, len, arr[0]);
        for(int i = 1; i<len; i++) {
            if(arr[i] != i) {
                int tmp = arr[i];
                swapWithZero(arr, len, tmp);
                swapWithZero(arr, len, i);
                swapWithZero(arr, len, tmp);
            }
        }
    }

    public static void main(String[] args) {
        sort(arr, arr.length);
        for(int i: arr)
            System.out.print(i + " " );
    }
}

/**
 * Created by lenovo on 2017/3/20.
 */
public class KLargest {
    public static int kLargest(int[] a, int k) {
        int bigger = 0;
        for(int i: a) {
            if(i>=k) bigger++;
        }
        return bigger;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,5,7,2};
        System.out.println(kLargest(a, 7));
    }
}

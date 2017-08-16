import java.util.*;

/**
 * Created by lenovo on 2017/3/20.
 */
public class KLargestInAandB {
    public static int kLargestInAandB(int[] a, int[] b, int k) {
        Queue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = a.length-1; i>=0; i--) {
            pq.add(a[i]);
        }
        for(int i = b.length-1; i>=0; i--) {
            pq.add(b[i]);
        }
        for(int i = 0; i<k-1; i++) System.out.println(pq.poll());
        return pq.poll();
    }

    public static void main(String[] args) {
        int[] a = {1,2,4};
        int[] b = {3,5,6};
        System.out.println(kLargestInAandB(a, b, 2));
    }
}

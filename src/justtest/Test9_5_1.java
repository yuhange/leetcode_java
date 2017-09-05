package justtest;

import java.util.*;
/**
 * Created by lenovo on 2017/9/5.
 */
public class Test9_5_1 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(input == null) return res;
        int n = input.length;
        if(n == 0 || n < k) return res;
        if(n == k) {
            for(int i: input) res.add(i);
            return res;
        }
        int i = 0;
        int j = n - 1;
        int index = 0;
        while(i < j) {
            index = partition(input, i, j);
//            System.out.println(index + " " + i + " " + j);
            if(index == k - 1) break;
            else if(index < k - 1) i = index + 1;
            else j = index;
        }
//        System.out.println(index);

        if(index != -1 && index < n) {
            for(int m = 0; m<=index; m++) res.add(input[m]);
        }
        return res;
    }

    private int partition(int[] input, int i, int j) {
        if(i > j) return -1;
        int pivot = input[i];
        while(i < j) {
            while(i < j && input[j] >= pivot) j--;
            if(i < j) input[i ++] = input[j];
            while(i < j && input[i] <= pivot) i++;
            if(i < j) input[j --] = input[i];
        }
        input[i] = pivot;
        return i;
    }

    public static void main(String[] args) {
        Test9_5_1 test = new Test9_5_1();
        int[] num = {4,5,1,6,2,7,3,8};
        System.out.println(test.GetLeastNumbers_Solution(num, 8).toString());
    }
}

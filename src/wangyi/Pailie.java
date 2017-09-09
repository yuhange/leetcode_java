package wangyi;

/**
 * Created by lenovo on 2017/9/9.
 */
import java.util.*;
public class Pailie {
    static List<List<Integer>> res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i<t; i++) {
            int n = sc.nextInt();
            int[] p = new int[n];
            for(int j = 0; j < n; j++){
                p[j] = sc.nextInt();
            }
            res = new ArrayList<List<Integer>>();
            permutation(p, 0);
            boolean OK = false;
            for(List<Integer> list: res) {
                boolean ok = true;
                for(int m = 0; m<list.size() - 1; m++) {
//                    System.out.print(list.get(m) + " ");
                    if(list.get(m) * list.get(m+1) % 4 != 0) {
                        ok = false;
                        break;
                    }
                }
                if(ok) {
                    OK = true;
                    break;
                }

            }
            if(OK) {
                System.out.println("Yes");
            } else
                System.out.println("No");
        }

    }
    private static void permutation(int[] nums, int s) {
        if(s == nums.length) {
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i<nums.length; i++) list.add(nums[i]);
            res.add(list);
        }
        for(int i = s; i<nums.length; i++) {
//            if(i > 0 && nums[i] == nums[i-1]) continue;
            int t = nums[s];
            nums[s] = nums[i];
            nums[i] = t;
//            boolean ok = true;
//            for(int j = 0; j<nums.length-1; j++) {
//                System.out.print(nums[j] + " ");
//                if(nums[j] * nums[j + 1] % 4 != 0) {
//                    ok = false;
//                    break;
//                }
//            }
//            System.out.println();
//            if(!ok) continue;
            permutation(nums, s+1);
//            if(s < nums.length - 1 && nums[s] * nums[s+1] % 4 != 0) continue;
            nums[i] = nums[s];
            nums[s] = t;
        }
    }
}

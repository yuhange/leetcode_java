/**
 * Created by lenovo on 2017/8/31.
 */

import java.util.*;
public class Meituan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        int[] sum = new int[n];
        for(int i = 0; i<n; i++) {
            num[i] = scanner.nextInt();
            if(i == 0) sum[i] = num[i];
            else {
                sum[i] = num[i] + sum[i - 1];
            }
        }
        int k = scanner.nextInt();
        int max = 0;
        for(int i = 0; i<n; i++) {
            for(int j = i + 1; j<n; j++) {
                if((sum[j]-sum[i]+num[i]) % k == 0) {
                    max = Math.max(max, (j - i + 1));
                }
            }
        }
        System.out.println(max);
    }
}

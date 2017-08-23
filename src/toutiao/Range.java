package toutiao;

import java.util.Scanner;

/**
 * Created by lenovo on 2017/8/22.
 */
public class Range {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[][] dpMin = new int[n][n];
        long[] dpSum = new long[n];
        long[][] dp = new long[n][n];
        long max = 0L;
        for(int i = 0; i<n; i++) {
            a[i] = scanner.nextInt();
            dpMin[i][i] = a[i];
        }
        for(int i = 0; i<n; i++) {
            if(i == 0) dpSum[0] = a[i];
            else dpSum[i] = dpSum[i-1] + a[i];
            for(int j = i + 1; j<n; j++) {
                dpMin[i][j] = Math.min(dpMin[i][j-1], a[j]);
            }
        }
//        for(int i = 0; i<n; i++) {
//            for(int j = i + 1; j<n; j++) {
//                System.out.print(i+" "+j+": "+dpMin[i][j]+"  ");
//            }
//            System.out.println();
//        }
        for(int i = 0; i<n; i++) {
            for(int j = i; j<n; j++) {
//                System.out.print(i+" "+j+": "+(dpSum[j]-dpSum[i] + a[i])+"  ");
                dp[i][j] = (dpSum[j]-dpSum[i] + a[i]) * dpMin[i][j];
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(max);
    }
}

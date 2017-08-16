package wangyi;

import java.util.*;
/**
 * Created by lenovo on 2017/8/12.
 */
public class Wangyi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long ans = 0;

//        System.out.println(cnt);
        long[][] dp = new long[n+1][k+1];
        dp[1][1] = 1;
        for(int i = 1; i<=k; i++) {
            dp[1][i] = k;
        }
        for(int i = 2; i<=n; i++) {
            for(int j = 2; j<=k; j++) {
                dp[i][j] = dp[i-1][j] * (k + count(k));
            }
        }
        System.out.println(dp[n][k]%1000000007);
    }

    private static int count(long m) {
        int cnt = 0;
        for(int i = 2; i<m; i++) {
            if(m % i == 0) cnt ++;
        }
        return cnt;
    }
}

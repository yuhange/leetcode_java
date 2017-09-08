package jingdong;

import java.util.Scanner;

/**
 * Created by lenovo on 2017/9/8.
 */
public class Log {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 6;
        for(int i = 3; i<=n; i++) {
            dp[i] = dp[i - 1] + 2 * i;
            for(int j = 2; j<i; j++) {
                int t = isLog(i, j);
                if(t != -1) {
                    dp[i] += 1;
                }
            }
        }
        System.out.println(dp[n] % 1000000007);
    }

    private static int isLog(int n, int i) {
        int t = 1;
        int I = i;
        while(i < n) {
            i *= I;
            t ++;
        }
        if(i == n) return t;
        return -1;
    }
}

package zhaoshangyinhang;

/**
 * Created by lenovo on 2017/9/13.
 */
import java.util.*;
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        for(int i = 0; i<n; i++) num[i] = scanner.nextInt();
        boolean win = firstCanWin(num);
        System.out.println(win);
    }

    private static boolean firstCanWin(int[] num) {
        if(num == null) return false;
        int n = num.length;
        if(n <= 2) return true;
        if(n == 3) return (num[0] + num[1] > num[2]);
        int[] dp = new int[n];
        dp[n - 1] = num[n - 1];
        dp[n - 2] = num[n - 1] + num[n - 2];
        dp[n - 3] = num[n - 2] + num[n - 3];
        for(int i = n - 4; i>=0; i--) {
            dp[i] = Math.max(num[i] + Math.min(dp[i - 1], dp[i-2]), num[i-1] + num[i] + Math.min(dp[i-2], dp[i-3]));
        }
        int sum = 0;
        for(int i: num) sum += i;
        return dp[n - 1] * 2 > sum;
    }
}

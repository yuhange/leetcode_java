package hdu;

/**
 * Created by lenovo on 2017/9/3.
 */
import java.util.*;
public class HDU1087 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            if(n == 0) return;
            int[] num = new int[n];
            int[] dp = new int[n];
            for(int i = 0; i<n; i++) {
                num[i] = scanner.nextInt();
            }
            dp[0] = num[0];
            for(int i = 1; i<n; i++) {
                dp[i] = num[i];
                for(int j = 0; j<i; j++) {
                    if(num[j] < num[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + num[i]);
                    }
                }
            }
            int max = Integer.MIN_VALUE;
            for(int i = 0; i<n; i++) {
                max = Math.max(dp[i], max);
            }
            System.out.println(max);
        }
    }
}

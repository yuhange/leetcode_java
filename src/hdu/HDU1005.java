package hdu;

/**
 * Created by lenovo on 2017/9/3.
 */
import java.util.*;
public class HDU1005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int A = scanner.nextInt();
            if(A == 0) return;
            int B = scanner.nextInt();
            int n = scanner.nextInt();
            int[] dp = new int[n+1];
            dp[1] = 1;
            dp[2] = 1;
            for(int i = 3; i<=n; i++) {
                dp[i] = (A * dp[i-1] + B * dp[i-2]) % 7;
            }
            System.out.println(dp[n]);
        }
    }
}

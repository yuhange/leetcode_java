package hdu;

/**
 * Problem Description
 A number sequence is defined as follows:

 f(1) = 1, f(2) = 1, f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.

 Given A, B, and n, you are to calculate the value of f(n).


 Input
 The input consists of multiple test cases. Each test case contains 3 integers A, B and n on a single line (1 <= A, B <= 1000, 1 <= n <= 100,000,000). Three zeros signal the end of input and this test case is not to be processed.


 Output
 For each test case, print the value of f(n) on a single line.


 Sample Input
 1 1 3
 1 2 10
 0 0 0


 Sample Output
 2
 5


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
            int[] dp = new int[10000];
            dp[1] = 1;
            dp[2] = 1;
            int i = 3;
            for(; i<10000; i++) {
                dp[i] = (A * dp[i-1] + B * dp[i-2]) % 7;
                if(dp[i] == 1 && dp[i-1] == 1) break; // 出现了两个连续的1，说明出现了周期
            }
            n = n % (i - 2);
            dp[0] = dp[i - 2];
            System.out.println(dp[n]);
        }
    }
}
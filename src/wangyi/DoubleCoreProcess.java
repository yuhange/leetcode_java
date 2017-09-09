package wangyi;

/**
 * 一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务。n个任务可以按照任意顺序放入CPU进行处理，现在需要设计一个方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。
 输入描述:
 输入包括两行： 第一行为整数n(1 ≤ n ≤ 50) 第二行为n个整数length[i](1024 ≤ length[i] ≤ 4194304)，表示每个任务的长度为length[i]kb，每个数均为1024的倍数。


 输出描述:
 输出一个整数，表示最少需要处理的时间
 */
import java.util.*;
public class DoubleCoreProcess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] p = new int[n];
        int sum = 0;
        for(int i = 0; i<n; i++) {
            p[i] = scanner.nextInt() >> 10;
            sum += p[i];
        }
        int dp[] = new int[sum/2 + 1];
        for(int i = 1; i<n; i++) {
            for(int j = sum/2; j>=p[i]; j--) {
                dp[j] = Math.max(dp[j - p[i]] + p[i], dp[j]);
            }
        }
        System.out.println(Math.max(dp[sum/2], sum - dp[sum/2]) << 10);
    }

}

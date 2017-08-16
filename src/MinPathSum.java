/**
 * Created by lenovo on 2017/3/21.
 */
public class MinPathSum {
    public static int minPathSum(int[][] a) {
        int dp[][] = new int[a.length][a[0].length];
        dp[0][0] = a[0][0];
        for(int i = 1; i<a[0].length; i++) dp[0][i] = dp[0][i-1] + a[0][i];
        for(int i = 1; i<a.length; i++) dp[i][0] = dp[i-1][0] + a[i][0];
        for(int i = 1; i<a.length; i++) {
            for(int j = 1; j<a[0].length; j++) {
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + a[i][j];
            }
        }
        return dp[a.length-1][a[0].length-1];
    }

    public static void main(String[] args) {
        int a[][] = {{1,3,5,9}, {8,1,3,4}, {5,0,6,1}, {8,8,4,0}};
        System.out.println(minPathSum(a));
    }
}

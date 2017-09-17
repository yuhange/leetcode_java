package leetcode.medium.dynamicprograming;

/**
 * We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

 However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

 Example:

 n = 10, I pick 8.

 First round:  You guess 5, I tell you that it's higher. You pay $5.
 Second round: You guess 7, I tell you that it's higher. You pay $7.
 Third round:  You guess 9, I tell you that it's lower. You pay $9.

 Game over. 8 is the number I picked.

 You end up paying $5 + $7 + $9 = $21.
 Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */
public class GuessNumberGameII {
    public int getMoneyAmount(int n) {
        if(n == 0) return 0;
        int[][] dp = new int[n+1][n+1];
        return binarySearch(dp, 1, n);
    }

    private int binarySearch(int[][] dp, int l, int r) {
        if(l >= r) return 0;
        if(dp[l][r] != 0) return dp[l][r];
        int min = Integer.MAX_VALUE;
        for(int i = l; i<=r; i++) {
            min = Math.min(min, i + Math.max(binarySearch(dp, l, i - 1), binarySearch(dp, i + 1, r))) ;
        }
        dp[l][r] = min;
        return min;
    }
}

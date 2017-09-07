package leetcode.medium.greedy;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time
 (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStocksII {
    public int maxProfit(int[] prices) {
        if(prices == null) return 0;
        int n = prices.length;
        if(n == 0) return 0;
        int sum = 0;
        int i = 0;
        while(i < n) {
            int cur = prices[i];
            int j = i + 1;
            while(j < n && prices[j] > prices[j - 1]) j ++; // 局部递增
            // System.out.println(cur + " " + prices[j - 1]);
            sum += Math.max(prices[j - 1] - cur, 0);
            i = j;
        }
        return sum;
    }
}

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */
public class BuySellStockIII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {3,2,6,5,0,3};
        System.out.println("max profit: " + solution.maxProfit(array));
    }

    public static class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length < 2) return 0;
            if (prices.length == 2)
                return (prices[1] > prices[0]) ?  (prices[1] - prices[0])  : 0;

            int[] maxProfitFromFront = new int[prices.length];
            int[] maxProfitFromEnd = new int[prices.length];

            int min = prices[0];
            int maxProfit = Integer.MIN_VALUE;

            maxProfitFromFront[0] = 0;
            for(int i=1; i < prices.length; i++) {
                if(prices[i] < min) {
                    min = prices[i];
                }
                if(prices[i] - min > maxProfit) {
                    maxProfit = prices[i] - min;
                }
                maxProfitFromFront[i] = maxProfit;
            }

            int max = prices[prices.length-1];
            maxProfit = 0;
            maxProfitFromEnd[prices.length-1] = 0;
            for(int i = prices.length-2; i >= 0; i--) {
                if(prices[i] > max) {
                    max = prices[i];
                }

                if(maxProfit < max - prices[i]) {
                    maxProfit = max - prices[i];
                }
                maxProfitFromEnd[i] = maxProfit;
            }

            max = Integer.MIN_VALUE;
            for(int i=1; i <= prices.length-3; i++) {
                if (maxProfitFromFront[i] + maxProfitFromEnd[i+1] > max) {
                    max = maxProfitFromFront[i] + maxProfitFromEnd[i+1];
                }
            }

            // If buy at beginning and sell at next max value only once
            if(maxProfitFromEnd[0] > max)  max = maxProfitFromEnd[0];
            // If Sell at end value and buy at any min value only once
            if(maxProfitFromFront[prices.length-1] > max) max = maxProfitFromFront[prices.length-1];

            return max;
        }
    }
}

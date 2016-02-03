/**
 * Created by abhijeet on 2/3/16.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class bestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if(prices.length == 1 || prices.length == 0 ) {
            return 0;
        }

        int profit = Integer.MIN_VALUE;
        int minSoFar = prices[0];

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < minSoFar) {
                minSoFar = prices[i];
            }

            if(prices[i] - minSoFar > profit) {
                profit = prices[i] - minSoFar;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println("Profit: " + maxProfit(prices));

        int[] prices1 = {5,3,2,4,5};
        System.out.println("Profit: " + maxProfit(prices1));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int currentMaxProfit = Math.max(0, prices[i] - min);
            maxProfit = Math.max(currentMaxProfit, maxProfit);
            min = Math.min(prices[i], min);
        }
        return maxProfit;
    }
}
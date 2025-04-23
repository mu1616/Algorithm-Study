class Solution {
    public int maxProfit(int[] prices) {
        Integer myStockPrice = null;
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                if (myStockPrice == null) {
                    myStockPrice = prices[i];
                    continue;
                }
            }
            if (prices[i] > prices[i + 1]) {
                if (myStockPrice == null) {
                    continue;
                }
                profit = profit + prices[i] - myStockPrice;
                myStockPrice = null;
            }
        }
        if (myStockPrice != null) {
            profit = profit + prices[prices.length - 1] - myStockPrice;
        }
        return profit;
    }
}
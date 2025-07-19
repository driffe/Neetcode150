public class SlideWindow {
    public int maxProfit(int[] prices) {
        int low = prices[0];
        int finalProfit = 0;
        int profit = 0;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < low) {
                low = prices[i];
            }
            profit = prices[i] - low;

            if(finalProfit < profit) {
                finalProfit = profit;
            }
        }
        return finalProfit;
    }
}

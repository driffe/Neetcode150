import java.util.HashSet;

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
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hset = new HashSet<>();
        int left = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            while (hset.contains(c)) {
                hset.remove(s.charAt(left));
                left++;
            }

            hset.add(c);
            if(result < hset.size()) {
                result = hset.size();
            }

        }

        return result;
    }

}

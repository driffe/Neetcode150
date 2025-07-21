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
    public boolean checkInclusion(String s1, String s2) {
        String sortedS1 = sortString(s1);

        for (int i = 0; i < s2.length(); i++) {
            char current = s2.charAt(i);

            if (s1.indexOf(current) != -1) {
                if (i + s1.length() <= s2.length()) {
                    String s2Sub = s2.substring(i, i + s1.length());
                    String s2SortedSub = sortString(s2Sub);

                    if (sortedS1.equals(s2SortedSub)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    private static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

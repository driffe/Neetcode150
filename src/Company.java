public class Company {
    public int minStartValue(int[] nums) {
        int startValue = 1;
        int sum = startValue;

        for (int num : nums) {
            sum += num;
            if (sum < 1) {
                int diff = 1 - sum;
                startValue += diff;
                sum += diff;
            }
        }

        return startValue;
    }
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i / 2] + (i % 2);
        }
        return dp;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hset = new HashSet<>();
        List<Integer> lst = new ArrayList<>();

        for(int n : nums1) {
            hset.add(n);
        }

        for(int m : nums2) {
            if(hset.contains(m)) {
                lst.add(m);
                hset.remove(m);
            }
        }

        int[] result = new int[lst.size()];
        for(int i = 0; i < lst.size(); i++) {
            result[i] = lst.get(i);
        }
        return result;
    }
    public boolean squareIsWhite(String coordinates) {
        int letter = coordinates.charAt(0);
        int number = coordinates.charAt(1);

        return (letter + number) % 2 == 1;
    }
}

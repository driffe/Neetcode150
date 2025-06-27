import java.util.*;

public class hash {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hset = new HashSet<Integer>();

        for(int i = 0; i < nums.length; i++) {
            if(hset.contains(nums[i])) {
                return true;
            }
            hset.add(nums[i]);
        }
        return false;
    }
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hmap01 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hmap02 = new HashMap<Character, Integer>();

        for(char ch : s.toCharArray()) {
            if(hmap01.containsKey(ch)) {
                hmap01.put(ch, hmap01.get(ch)+1);
            } else {
                hmap01.put(ch, 1);
            }
        }
        for(char ch : t.toCharArray()) {
            if(hmap02.containsKey(ch)) {
                hmap02.put(ch, hmap02.get(ch)+1);
            } else {
                hmap02.put(ch, 1);
            }
        }

        return hmap01.equals(hmap02);
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[2];
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hmap = new HashMap<>();

        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            System.out.println(chars);
            String key = new String(chars);

            if(hmap.containsKey(key)) {
                hmap.get(key).add(str);
            } else {
                List<String> lst = new ArrayList<>();
                lst.add(str);
                hmap.put(key, lst);
            }
        }
        return new ArrayList<>(hmap.values());
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int[] result = new int[k];

        for(int num: nums) {
            if(hmap.containsKey(num)) {
                hmap.put(num, hmap.get(num) + 1);
            } else {
                hmap.put(num, 1);
            }
        }

        for(int i = 0; i < k; i++) {
            int max = Collections.max(hmap.entrySet(), Map.Entry.comparingByValue()).getKey();
            result[i] = max;
            hmap.remove(max);
        }
        return result;
    }
}

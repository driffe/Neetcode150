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
    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for(String s : strs) {
            result.append(s).append("\n");
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            int j = str.indexOf('\n', i);
            String temp = str.substring(i, j);
            result.add(temp);
            i = j + 1;
        }
        return result;
    }
    public int[] productExceptSelf(int[] nums) {
        int nonzero_temp = 1;
        int zero_count = 0;
        for(int n : nums) {
            if(n == 0) {
                zero_count++;
            } else {
                nonzero_temp *= n;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int n : nums) {
            if(zero_count == 0) {
                nonzero_temp /= n;
                result.add(nonzero_temp);
                nonzero_temp *= n;
            } else if(zero_count == 1) {
                if(n == 0) {
                    result.add(nonzero_temp);
                } else {
                    result.add(0);
                }
            } else {
                result.add(0);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] != '.') {
                    char num = board[i][j];

                    if(!rowCheck(board, i, num) ||
                            !columnCheck(board, j, num) ||
                            !boxCheck(board, i, j, num)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean rowCheck(char[][] board, int row, char num) {
        int count = 0;
        for(int i = 0; i < board.length; i++) {
            if(board[row][i] == num) {
                count++;
            }
        }
        if(count == 1) {
            return true;
        }
        return false;
    }

    private boolean columnCheck(char[][] board, int col, char num) {
        int count = 0;
        for(int i = 0; i < board.length; i++) {
            if(board[i][col] == num) {
                count++;
            }
        }
        if(count == 1) {
            return true;
        }
        return false;
    }

    private boolean boxCheck(char[][] board, int row, int col, char num) {
        int count = 0;
        int box_row = (row / 3) * 3;
        int box_col = (col / 3) * 3;
        for(int i = box_row; i < box_row+3; i++) {
            for(int j = box_col; j < box_col+3; j++) {
                if(board[i][j] == num) {
                    count++;
                }
            }
        }
        if(count == 1) {
            return true;
        }
        return false;
    }
}

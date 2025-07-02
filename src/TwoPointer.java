import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointer {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public int[] twoSum(int[] numbers, int target) {
        // 0 3 5 7
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
            if(numbers[left] + numbers[right] == target) {
                result[0] = left+1;
                result[1] = right+1;
                break;
            } else if(numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
    //다시 풀어볼 문제
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int first = 0;
        int second = first + 1;
        int third = nums.length - 1;

        while (first < nums.length - 2) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                first++;
                second = first + 1;
                third = nums.length - 1;
                continue;
            }

            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[first], nums[second], nums[third]));

                    while (second + 1 < third && nums[second] == nums[second + 1]) {
                        second++;
                    }
                    while (third - 1 > second && nums[third] == nums[third - 1]) {
                        third--;
                    }

                    second++;
                    third--;
                } else if (sum > 0) {
                    third--;
                } else {
                    second++;
                }
            }
            first++;
            second = first + 1;
            third = nums.length - 1;
        }

        return result;
    }
}

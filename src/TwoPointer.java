import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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
    public int maxArea(int[] heights) {
        int length = heights.length - 1;
        int left = 0;
        int right = heights.length - 1;
        int max = 0;
        int temp = 0;
        while(left < right) {
            if(heights[left] < heights[right]) {
                temp = length * heights[left];
                left++;
            } else {
                temp = length * heights[right];
                right--;
            }
            length--;
            if(max < temp) {
                max = temp;
            }
            System.out.println(temp);
        }

        return max;
    }
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;

        while (left < right) {
            if(leftMax < height[left]) {
                leftMax = height[left];
            }
            if(rightMax < height[right]) {
                rightMax = height[right];
            }

            if (leftMax < rightMax) {
                result += leftMax - height[left];
                left++;
            } else {
                result += rightMax - height[right];
                right--;
            }
            System.out.println(left + "," + right);
            System.out.println(leftMax + "," + rightMax + "," + result);
        }

        return result;
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] parentheses = s.toCharArray();

        for(char c : parentheses) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else if (c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int min;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        min = 0;
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val < minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if(!stack.isEmpty()) {
            int temp = stack.pop();
            if (temp == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}

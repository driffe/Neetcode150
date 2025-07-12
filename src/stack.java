import java.util.Arrays;
import java.util.Stack;

public class stack {
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

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String str : tokens) {
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int second = stack.pop();
                int first = stack.pop();

                int result = 0;
                switch(str) {
                    case "+": result = first + second; break;
                    case "-": result = first - second; break;
                    case "*": result = first * second; break;
                    case "/": result = first / second; break;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.pop();
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length - 1; i++) {
            int count = 0;
            for(int j = i + 1; j < temperatures.length; j++) {
                count++;
                if(temperatures[j] > temperatures[i]) {
                    result[i] = count;
                    break;
                }
            }

        }

        return result;
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Stack<Double> stack = new Stack<>();

        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        for (int i = 0; i < cars.length; i++) {
            double time = cars[i][1];

            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }

}

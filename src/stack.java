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
}

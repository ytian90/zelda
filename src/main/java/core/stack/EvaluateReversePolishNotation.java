package core.stack;

import java.util.Stack;

/**
 * LC 150. Evaluate Reverse Polish Notation
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int p = stack.pop();
                stack.push(calculate(token, stack.pop(), p));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }

    private int calculate(String op, int p, int q) {
        if ("+".equals(op)) {
            return p + q;
        } else if ("-".equals(op)) {
            return p - q;
        } else if ("*".equals(op)) {
            return p * q;
        } else if ("/".equals(op)) {
            return p / q;
        }
        return -1;
    }
    // T/S: O(N)
}

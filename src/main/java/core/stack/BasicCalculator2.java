package core.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC 227. Basic Calculator
 */
public class BasicCalculator2 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        int currNumber = 0;
        char operator = '+';
        for (int i = 0; i < n; i++) {
            char currChar = s.charAt(i);
            if (Character.isDigit(currChar)) {
                currNumber = 10 * currNumber + (currChar - '0');
            }
            if (!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == n - 1) {
                if (operator == '+') {
                    stack.push(currNumber);
                } else if (operator == '-') {
                    stack.push(-currNumber);
                } else if (operator == '*') {
                    stack.push(stack.pop() * currNumber);
                } else if (operator == '/') {
                    stack.push(stack.pop() / currNumber);
                }
                currNumber = 0;
                operator = currChar;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
    // TS: O(N)

    public int calculate2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int currNumber = 0, lastNumber = 0, res = 0;
        char operator = '+';
        for (int i = 0; i < n; i++) {
            char currChar = s.charAt(i);
            if (Character.isDigit(currChar)) {
                currNumber = 10 * currNumber + (currChar - '0');
            }
            if (!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == n - 1) {
                if (operator == '+') {
                    res += lastNumber;
                    lastNumber = currNumber;
                } else if (operator == '-') {
                    res += lastNumber;
                    lastNumber = -currNumber;
                } else if (operator == '*') {
                    lastNumber = lastNumber * currNumber;
                } else if (operator == '/') {
                    lastNumber = lastNumber / currNumber;
                }
                currNumber = 0;
                operator = currChar;
            }
        }
        res += lastNumber;
        return res;
    }
    // T: O(N)
    // S: O(1)

}

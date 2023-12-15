package core.stack;

import core.utils.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC 224. Basic Calculator
 */
public class BasicCalculator {
    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int currNumber = 0, res = 0;
        int sign = 1;
        Deque<Pair<Integer, Integer>> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char currChar = s.charAt(i);
            if (Character.isDigit(currChar)) {
                currNumber = 10 * currNumber + (currChar - '0');
            }
            if (currChar == '+') {
                res += sign * currNumber;
                currNumber = 0;
                sign = 1;
            } else if (currChar == '-') {
                res += sign * currNumber;
                currNumber = 0;
                sign = -1;
            } else if (currChar == '(') {
                stack.push(new Pair(sign, res));
                res = 0;
                sign = 1;
            } else if (currChar == ')') {
                res += sign * currNumber;
                currNumber = 0;
                Pair p = stack.pop();
                res *= (int) p.getKey();
                res += (int) p.getValue();
            }
        }
        if (currNumber != 0) {
            res += sign * currNumber;
        }
        return res;
    }
    // TS: O(N)

    public static void main(String[] args) {
        System.out.println(calculate("1 + 1"));
    }

}

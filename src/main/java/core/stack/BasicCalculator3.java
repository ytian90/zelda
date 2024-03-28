package core.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 772. Basic Calculator III
 */
public class BasicCalculator3 {
    public int calculate(String s) {
        Queue<Character> tokens = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                tokens.add(c);
            }
        }
        tokens.add('+');
        return calculate(tokens);
    }

    private int calculate(Queue<Character> q) {
        char prevOp = '+';
        int num = 0, sum = 0, prev = 0;
        while (!q.isEmpty()) {
            char c = q.poll();
            if (c >= '0' && c <= '9') {
                num = 10 * num + (c - '0');
            } else if (c == '(') {
                num = calculate(q);
            } else {
                if (prevOp == '+') {
                    sum += prev;
                    prev = num;
                } else if (prevOp == '-') {
                    sum += prev;
                    prev = -num;
                } else if (prevOp == '*') {
                    prev *= num;
                } else if (prevOp == '/') {
                    prev /= num;
                }
                if (c == ')') {
                    break;
                }
                prevOp = c;
                num = 0;
            }
        }
        return sum + prev;
    }
    // TS: O(N)
}

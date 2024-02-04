package core.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC 1963. Minimum Number of Swaps to Make the String Balanced
 */
public class MinimumNumberOfSwapsToMakeTheStringBalanced {
    // stack
    public int minSwaps(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int misMatch = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    misMatch++;
                }
            }
        }
        return (misMatch + 1) / 2;
    }
    // TS: O(N)

    public int minSwaps2(String s) {
        int stackSize = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stackSize++;
            } else {
                if (stackSize > 0) {
                    stackSize--;
                }
            }
        }
        return (stackSize + 1) / 2;
    }
    // T: O(N)
    // S: O(1)

}

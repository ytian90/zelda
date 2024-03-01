package core.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC 388. Longest Absolute File Path
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int maxLen = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            while (level + 1 < stack.size()) { // find parent
                stack.pop();
            }
            int len = stack.peek() + s.length() - level + 1; // remove "/t", add "/"
            stack.push(len);
            if (s.contains(".")) {
                maxLen = Math.max(maxLen, len - 1);
            }
        }
        return maxLen;
    }
    // TS: O(N)
}

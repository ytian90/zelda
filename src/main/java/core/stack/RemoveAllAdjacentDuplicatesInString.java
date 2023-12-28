package core.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC 1047. Remove All Adjacent Duplicates in String
 */
public class RemoveAllAdjacentDuplicatesInString {
    // stack
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (c == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    // TS: O(N)

    // array as stack
    public static String removeDuplicates2(String s) {
        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; j++, i++) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i]) {
                i -= 2;
            }
        }
        return new String(res, 0, i);
    }
    // TS: O(N)

    public static void main(String[] args) {
        System.out.println(removeDuplicates2("abbaca"));
    }

}

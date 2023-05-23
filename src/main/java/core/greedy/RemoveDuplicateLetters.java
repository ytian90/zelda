package core.greedy;

import java.util.Stack;

/**
 * LC 316. Remove Duplicate Letters
 */
public class RemoveDuplicateLetters {
    // Greedy: solve by letter
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;
            }
            if (--count[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1)
                .replace(s.charAt(pos) + "", ""));
    }
    // T/S: O(N)

    // Greedy: solve by stack
    public String removeDuplicateLetters2(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        boolean[] visited = new boolean[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            if (visited[c - 'a']) continue;
            // stack is not empty, top is after c and there are other occurrences later
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
    // T: O(N)
    // S: O(1)
}

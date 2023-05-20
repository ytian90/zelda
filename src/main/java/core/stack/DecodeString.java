package core.stack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * LC 394. Decode String
 */
public class DecodeString {
    // two stack
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currString = new StringBuilder();
        int currCount = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currCount = 10 * currCount + c - '0';
            } else if (c == '[') {
                countStack.push(currCount);
                stringStack.push(currString);
                currCount = 0;
                currString = new StringBuilder();
            } else if (c == ']') {
                StringBuilder decodedString = stringStack.pop();
                decodedString.append(String.valueOf(currString).repeat(Math.max(0, countStack.pop())));
                currString = decodedString;
            } else {
                currString.append(c);
            }
        }
        return currString.toString();
    }
    // Time: O(N * MAX[currCount]), where N is the length of string s, MAX[currCount] is the max value of currCount.
    // Space: O(m + n), where m is the number of letters(a-z), m is the number of digits(0-9) in string s.

    // recursion
    public static String decodeString2(String s) {
        Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            q.add(c);
        }
        return helper(q);
    }

    private static String helper(Queue<Character> q) {
        StringBuilder currString = new StringBuilder();
        int currCount = 0;
        while (!q.isEmpty()) {
            char c = q.poll();
            if (Character.isDigit(c)) {
                currCount = 10 * currCount + c - '0';
            } else if (c == '[') {
                String sub = helper(q);
                currString.append(sub.repeat(currCount));
                currCount = 0;
            } else if (c == ']') {
                break;
            } else {
                currString.append(c);
            }
        }
        return currString.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString2("3[a2[c]]"));
    }
}

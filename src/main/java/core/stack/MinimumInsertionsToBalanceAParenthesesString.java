package core.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC 1541. Minimum Insertions to Balance a Parentheses String
 */
public class MinimumInsertionsToBalanceAParenthesesString {
    public static int minInsertions(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length(), res = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    if (i != n - 1) {
                        if (s.charAt(i + 1) == ')') {
                            res++;
                            i++;
                        } else res += 2;
                    } else {
                        res += 2;
                    }
                } else {
                    if (i != n - 1) {
                        if (s.charAt(i + 1) == ')') {
                            stack.pop();
                            i++;
                        } else {
                            res++;
                            stack.pop();
                        }
                    } else {
                        res++;
                        stack.pop();
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            res += 2 * stack.size();
        }
        return res;
    }
    // TS: O(N)

    // refactor, combine logics
    public int minInsertions2(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length(), res = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    res++;
                    if (i != n - 1 && s.charAt(i + 1) == ')') {
                        i++;
                    } else {
                        res++;
                    }
                } else {
                    stack.pop();
                    if (i != n - 1 && s.charAt(i + 1) == ')') {
                        i++;
                    } else {
                        res++;
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            res += 2 * stack.size();
        }
        return res;
    }
    // TS: O(N)

    public int minInsertions3(String s) {
        int balance = 0;
        int n = s.length(), res = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                balance++;
            } else {
                if (balance <= 0) {
                    res++;
                    if (i != n - 1 && s.charAt(i + 1) == ')') {
                        i++;
                    } else {
                        res++;
                    }
                } else {
                    balance--;
                    if (i != n - 1 && s.charAt(i + 1) == ')') {
                        i++;
                    } else {
                        res++;
                    }
                }
            }
        }
        if (balance > 0) {
            res += 2 * balance;
        }
        return res;
    }
    // T: O(N)
    // S: O(1)

    public static void main(String[] args) {
        System.out.println(minInsertions("(()))"));
        System.out.println(minInsertions("()()()()()("));
    }

}

package core.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LC 301. Remove Invalid Parentheses
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int rmL = 0, rmR = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                rmL++;
            } else if (c == ')') {
                if (rmL > 0) {
                    rmL--;
                } else {
                    rmR++;
                }
            }
        }
        Set<String> res = new HashSet<>();
        helper(s, 0, new StringBuilder(), res, rmL, rmR, 0);
        return new ArrayList<>(res);
    }

    private void helper(String s, int i, StringBuilder sb, Set<String> res, int rmL, int rmR, int open) {
        if (rmL < 0 || rmR < 0 || open < 0) {
            return;
        }
        if (i == s.length()) {
            if (rmL == 0 && rmR == 0 && open == 0) {
                res.add(sb.toString());
            }
            return;
        }
        int size = sb.length();
        char c = s.charAt(i);
        if (c == '(') {
            helper(s, i + 1, sb, res, rmL - 1, rmR, open);
            helper(s, i + 1, sb.append(c), res, rmL, rmR, open + 1);
        } else if (c == ')') {
            helper(s, i + 1, sb, res, rmL, rmR - 1, open);
            helper(s, i + 1, sb.append(c), res, rmL, rmR, open - 1);
        } else {
            helper(s, i + 1, sb.append(c), res, rmL, rmR, open);
        }
        sb.setLength(size);
    }
    // T: O(2 ^ N), for each position, we need to consider choose it or remove it, all N parentheses, so O(2 ^ N)
    // S: O(N), the maximum depth of recursion decides the stack space used, so O(N)

}

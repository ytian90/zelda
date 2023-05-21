package core.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 22. Generate Parentheses
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        helper(new StringBuilder(), n, n, n, res);
        return res;
    }

    private void helper(StringBuilder sb, int left, int right, int n, List<String> res) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            sb.append("(");
            helper(sb, left - 1, right, n, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > 0) {
            sb.append(")");
            helper(sb, left, right - 1, n, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    // T: O(2 ^ (2*N)) = O(4 ^ N)
    // S: O(N)
}

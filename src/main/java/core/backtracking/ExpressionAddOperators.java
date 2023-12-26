package core.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 282. Expression Add Operators
 */
public class ExpressionAddOperators {
    public static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        helper(num, target, res, new StringBuilder(), 0, 0, 0);
        return res;
    }

    private static void helper(String num, int target, List<String> res, StringBuilder sb, int pos, long value, long multiply) {
        if (pos == num.length()) {
            if (value == target) {
                res.add(sb.toString());
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') { // more than 1 digit with starting 0, such as 05, invalid
                break;
            }
            long curr = Long.parseLong(num.substring(pos, i + 1));
            int len = sb.length();
            if (pos == 0) {
                helper(num, target, res, sb.append(curr), i + 1, value + curr, curr);
                sb.setLength(len);
            } else {
                helper(num, target, res, sb.append("+").append(curr), i + 1, value + curr, curr);
                sb.setLength(len);

                helper(num, target, res, sb.append("-").append(curr), i + 1, value - curr, -curr);
                sb.setLength(len);

                helper(num, target, res, sb.append("*").append(curr), i + 1, value - multiply + curr * multiply, curr * multiply);
                sb.setLength(len);
            }
        }
    }
    // T: O(N * 4 ^ N), 4 choices +, -, *, append for each digit
    // S: O(N)

    public static void main(String[] args) {
        System.out.println(addOperators("105", 5));
    }

}

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
    /*
    Let say the expression string formed so far is 1 + 2 (eval is 3)
    in current step let say we cur is 3 (i.e. the remnant string expression till end)
    we can choose to add, subtract or multiply 3 to the evaluated value (eval)
    however, if we choose multiply 3 (i.e. 1 + 2 * 3), then the answer should be 7
    this is where multed (i.e. 2) shall help us, which is basically the last value that contributed to the current eval

    We're interested in this cryptic invocation in recursion:

    helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur )

    so, to ensure we take operator precedence in computing the current value of eval and compute the expression
    as 1 + (2 * 3) = 7 and not (1 + 2) * 3 = 9, we do following :
    eval - multed + multed * cur
    eval : 3
    multed : 2
    cur : 3

    and set the last contributed value to eval as multed * current
     */

    public static void main(String[] args) {
        System.out.println(addOperators("105", 5));
    }

}

package core.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 17. Letter Combinations Of A Phone Number
 */
public class LetterCombinationsOfAPhoneNumber {
    private static String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        helper(digits, new StringBuilder(), 0, res);
        return res;
    }

    private void helper(String digits, StringBuilder sb, int start, List<String> res) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (char c : map[digits.charAt(start) - '0'].toCharArray()) {
            sb.append(c);
            helper(digits, sb, start + 1, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    // T: O(N * 4 ^ N), where N is the length of digits.
    // S: O(N)
}

package core.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 131. Palindrome Partitioning
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(s, 0, list, res);
        return res;
    }

    private void helper(String s, int pos, List<String> list, List<List<String>> res) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            String sub = s.substring(pos, i + 1);
            if (isPalindrome(sub)) {
                list.add(sub);
                helper(s, i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    // T: O(N * 2 ^ N), where N is the length of string s
    // S: O(N)
}

package core.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 267. Palindrome Permutation II
 */
public class PalindromePermutation2 {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        int oddCount = 0;
        for (int i : map) {
            if (i % 2 == 1) {
                oddCount++;
            }
        }
        if (oddCount > 1) {
            return res;
        }
        int totalCharCount = 0;
        String oddChar = "";
        for (int i = 0; i < map.length; i++) {
            if (map[i] % 2 == 1) {
                oddCount++;
                oddChar = (char) ('a' + i) + "";
                map[i]--;
            }
            map[i] = map[i] / 2;
            totalCharCount += map[i];
        }
        helper(map, totalCharCount, new StringBuilder(), oddChar, res);
        return res;
    }

    private void helper(int[] map, int totalCharCount, StringBuilder word, String oddChar, List<String> res) {
        if (totalCharCount == word.length()) {
            String revString = word.reverse().toString();
            res.add(word.reverse() + oddChar + revString);
            return;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0) {
                continue;
            }
            map[i]--;
            word.append((char) ('a' + i));
            helper(map, totalCharCount, word, oddChar, res);
            map[i]++;
            word.deleteCharAt(word.length() - 1);
        }
    }
    // T: O((N / 2)!)
    // S: O(N)
}

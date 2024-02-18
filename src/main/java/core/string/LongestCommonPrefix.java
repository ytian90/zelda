package core.string;

import java.util.Arrays;

/**
 * LC 14. Longest Common Prefix
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(strs[0]);
        for (String s : strs) {
            while (!sb.isEmpty() && !s.startsWith(sb.toString())) {
                sb.deleteCharAt(sb.length() - 1);
            }
            if (sb.isEmpty()) {
                return "";
            }
        }
        return sb.toString();
    }
    // T: O(N * M), where N is the length of strs, M is the longest string length
    // S: O(M)

    public String longestCommonPrefix2(String[] strs) {
        Arrays.sort(strs);
        String s = strs[0];
        String t = strs[strs.length - 1];
        int i = 0;
        while (i < s.length() && i < t.length()) {
            if (s.charAt(i) == t.charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        return s.substring(0, i);
    }
    // T: O(N * logN)
    // S: O(N)
}

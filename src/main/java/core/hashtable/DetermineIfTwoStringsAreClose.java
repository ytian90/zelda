package core.hashtable;

import java.util.Arrays;

/**
 * LC 1657. Determine if Two Strings are Close
 */
public class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] a = new int[26];
        int[] b = new int[26];
        for (char c : word1.toCharArray()) {
            a[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            b[c - 'a']++;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 && b[i] == 0 || a[i] == 0 && b[i] > 0) {
                return false;
            }
        }
        Arrays.sort(a); // only 26
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }
    // T: O(N)
    // S: O(1)
}

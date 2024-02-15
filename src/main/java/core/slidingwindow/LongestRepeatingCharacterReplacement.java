package core.slidingwindow;

/**
 * LC 424. Longest Repeating Character Replacement
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLen = 0;
        for (int end = 0; end < n; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
    // T: O(N)
    // S: O(26)
}

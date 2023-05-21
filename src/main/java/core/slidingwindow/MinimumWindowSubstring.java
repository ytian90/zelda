package core.slidingwindow;

/**
 * LC 76. Minimum Window Substring
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int prev = 0, minStart = 0, minLen = Integer.MAX_VALUE / 2, counter = t.length();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (map[currChar] > 0) {
                counter--;
            }
            map[currChar]--;
            while (counter == 0) {
                if (minLen > i - prev + 1) {
                    minLen = i - prev + 1;
                    minStart = prev;
                }
                char prevChar = s.charAt(prev);
                map[prevChar]++;
                if (map[prevChar] > 0) {
                    counter++;
                }
                prev++;
            }
        }
        return minLen == Integer.MAX_VALUE / 2 ? "" : s.substring(minStart, minStart + minLen);
    }
    // T: O(N + M)
    // S: O(1)
}

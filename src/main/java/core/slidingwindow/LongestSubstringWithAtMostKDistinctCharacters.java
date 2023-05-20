package core.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 340. Longest Substring with At Most K Distinct Characters
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // <char, counter>
        Map<Character, Integer> map = new HashMap<>();
        int prev = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                char prevChar = s.charAt(prev);
                map.put(prevChar, map.get(prevChar) - 1);
                if (map.get(prevChar) == 0) {
                    map.remove(prevChar);
                }
                prev++;
            }
            res = Math.max(res, i - prev + 1);
        }
        return res;
    }
    // Time: O(N), where N is the length of s.
    // Space: O(K)
}

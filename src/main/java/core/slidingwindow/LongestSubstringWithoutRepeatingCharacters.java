package core.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 3. Longest Substring Without Repeating Characters
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int prev = 0, res = 0;
        // <char, char_index>
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && prev <= map.get(c)) {
                prev = map.get(c) + 1;
            }
            map.put(c, i);
            res = Math.max(res, i - prev + 1);
        }
        return res;
    }
    // Time and Space: O(N)
}

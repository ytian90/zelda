package core.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 290. Word Pattern
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(w)) {
                    return false;
                }
            } else {
                for (String v : map.values()) {
                    if (v.equals(w)) {
                        return false;
                    }
                }
                map.put(c, w);
            }
        }
        return true;
    }
    // T: O(N ^ 2)
    // S: O(N)

    public boolean wordPattern2(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(w)) {
                    return false;
                }
            } else {
                if (map2.containsKey(w)) {
                    return false;
                }
                map.put(c, w);
                map2.put(w, c);
            }
        }
        return true;
    }
    // TS: O(N)
}

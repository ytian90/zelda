package core.hashtable;

import java.util.*;

/**
 * LC 451. Sort Characters by Frequency
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int maxFreq = Collections.max(map.values());
        List<List<Character>> buckets = new ArrayList<>();
        for (int i = 0; i <= maxFreq; i++) {
            buckets.add(new ArrayList<>());
        }
        for (Character c : map.keySet()) {
            int freq = map.get(c);
            buckets.get(freq).add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.size() - 1; i >= 0; i--) {
            for (Character c : buckets.get(i)) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
    // TS: O(N)
}

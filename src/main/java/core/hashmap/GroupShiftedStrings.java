package core.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC 249. Group Shifted Strings
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String hashKey = getHash(s);
            map.putIfAbsent(hashKey, new ArrayList<>());
            map.get(hashKey).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private String getHash(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            sb.append((char) ((chars[i] - chars[i - 1] + 26) % 26 + 'a'));
        }
        return sb.toString();
    }
    // TS: O(N * K), where N is the length of Strings, K is the maximum length of string in strings.
}

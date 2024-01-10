package core.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC 676. Implement Magic Dictionary
 */
public class ImplementMagicDictionary {
    Map<String, List<int[]>> map;

    public ImplementMagicDictionary() {
        this.map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            for (int i = 0; i < s.length(); i++) {
                String key = s.substring(0, i) + s.substring(i + 1);
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(new int[]{i, s.charAt(i)});
            }
        }
    }

    public boolean search(String searchWord) {
        for (int i = 0; i < searchWord.length(); i++) {
            String key = searchWord.substring(0, i) + searchWord.substring(i + 1);
            if (map.containsKey(key)) {
                for (int[] pair : map.get(key)) {
                    if (pair[0] == i && pair[1] != searchWord.charAt(i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    // TS: O(N)

}

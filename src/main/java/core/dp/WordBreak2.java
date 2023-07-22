package core.dp;

import java.util.*;

/**
 * LC 140. Word Break II
 */
public class WordBreak2 {
    // DFS + memo
    Map<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, new HashSet<>(wordDict));
    }

    private List<String> helper(String s, Set<String> dict) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> res = new ArrayList<>();
        if (dict.contains(s)) {
            res.add(s);
        }
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            if (dict.contains(left)) {
                for (String right : helper(s.substring(i), dict)) {
                    res.add(left + " " + right);
                }
            }
        }
        map.put(s, res);
        return res;
    }
    // TS: O(2 ^ N)

}

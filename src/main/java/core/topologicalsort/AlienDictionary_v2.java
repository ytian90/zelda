package core.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC 269. Alien Dictionary
 */
public class AlienDictionary_v2 {
    // dfs
    private Map<Character, List<Character>> reverseAdj = new HashMap<>();
    private Map<Character, Boolean> seen = new HashMap<>();
    private StringBuilder output = new StringBuilder();

    public String alienOrder(String[] words) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                reverseAdj.putIfAbsent(c, new ArrayList<>());
            }
        }
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char a = word1.charAt(j), b = word2.charAt(j);
                if (a != b) {
                    reverseAdj.get(b).add(a);
                    break;
                }
            }
        }
        for (Character c : reverseAdj.keySet()) {
            boolean res = dfs(c);
            if (!res) {
                return "";
            }
        }
        return output.toString();
    }

    private boolean dfs(Character c) {
        if (seen.containsKey(c)) {
            return seen.get(c);
        }
        seen.put(c, false);
        for (Character next : reverseAdj.get(c)) {
            boolean res = dfs(next);
            if (!res) return false;
        }
        seen.put(c, true);
        output.append(c);
        return true;
    }
    // T: O(M), where M is the total length of all the words in the input list
    // S: O(N)

}

package core.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 953. Verifying an Alien Dictionary
 */
public class VerifyingAnAlienDictionary {
    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            if (invalid(word1, word2, map)) {
                return false;
            }
        }
        return true;
    }

    private static boolean invalid(String a, String b, Map<Character, Integer> map) {
        if (a.length() > b.length() && a.startsWith(b)) {
            return true;
        }
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (map.get(a.charAt(i)) > map.get(b.charAt(i))) {
                    return true;
                }
                break;
            }
        }
        return false;
    }
    // T: O(N)
    // S: O(1)

    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }

}

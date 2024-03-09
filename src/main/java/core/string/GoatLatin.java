package core.string;

import java.util.HashSet;
import java.util.Set;

/**
 * LC 824. Goat Latin
 */
public class GoatLatin {
    public String toGoatLatin(String sentence) {
        Set<Character> set = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) {
            set.add(c);
        }
        StringBuilder res = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            res.append(" ");
            if (set.contains(w.charAt(0))) {
                res.append(w);
            } else {
                res.append(w.substring(1));
                res.append(w.charAt(0));
            }
            res.append("ma");
            for (int j = 0; j <= i; j++) {
                res.append("a");
            }
        }
        return res.substring(1);
    }
    // T: O(N)
    // S: O(1)
}

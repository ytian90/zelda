package core.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC 30. Substring with Concatenation of All Words
 */
public class SubstringWithConcatenationOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int size = words[0].length(), n = words.length;
        for (int i = 0; i < s.length() - n * size + 1; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0; // the count of the number of current words
            while (j < n) {
                String word = s.substring(i + j * size, i + (j + 1) * size);
                if (map.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > map.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break; // word is not expected
                }
                j++;
            }
            if (j == n) {
                res.add(i);
            }
        }
        return res;
    }
    // T: O(N * A * B), where N is the length of s, A is the length of words, B is each word length
    // S: O(M)

    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }

}

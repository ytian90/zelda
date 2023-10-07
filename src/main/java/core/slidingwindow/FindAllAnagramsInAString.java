package core.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC 438. Find All Anagrams in a String
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() > s.length()) {
            return res;
        }
        int n = s.length(), m = p.length();
        int[] pmap = new int[26];
        for (char c : p.toCharArray()) {
            pmap[c - 'a']++;
        }
        int[] smap = new int[26];
        for (int i = 0; i < m; i++) {
            smap[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pmap, smap)) {
            res.add(0);
        }
        for (int i = m, prev = 0; i < n; i++, prev++) {
            smap[s.charAt(i) - 'a']++;
            smap[s.charAt(prev) - 'a']--;
            if (Arrays.equals(pmap, smap)) {
                res.add(prev + 1);
            }
        }
        return res;
    }
    // T: O(N + M)
    // S: O(1)
}

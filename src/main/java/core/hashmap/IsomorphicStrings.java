package core.hashmap;

import java.util.Arrays;

/**
 * LC 205. Isomorphic Strings
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int[] st = new int[256];
        int[] ts = new int[256];
        Arrays.fill(st, -1);
        Arrays.fill(ts, -1);
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (st[a] == -1 && ts[b] == -1) {
                st[a] = b;
                ts[b] = a;
            } else if (st[a] != b || ts[b] != a) {
                return false;
            }
        }
        return true;
    }
    // T: O(N)
    // S: O(1)
}

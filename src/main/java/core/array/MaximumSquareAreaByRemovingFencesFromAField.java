package core.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LC 2975. Maximum Square Area by Removing Fences From a Field
 */
public class MaximumSquareAreaByRemovingFencesFromAField {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        long res = 0, mod = (long) (1e9 + 7);
        Set<Integer> set = new HashSet<>();
        int len1 = hFences.length, len2 = vFences.length;
        int[] a = Arrays.copyOf(hFences, len1 + 2);
        int[] b = Arrays.copyOf(vFences, len2 + 2);
        a[len1] = 1;
        a[len1 + 1] = m;
        b[len2] = 1;
        b[len2 + 1] = n;
        for (int i : a) {
            for (int j : a) {
                if (i != j) {
                    set.add(Math.abs(i - j));
                }
            }
        }
        for (int i : b) {
            for (int j : b) {
                if (set.contains(Math.abs(i - j))) {
                    res = Math.max(res, Math.abs(i - j));
                }
            }
        }
        return res == 0 ? -1 : (int) ((res * res) % mod);
    }
    // T: O(N + M)
    // S: O(N + M)
}

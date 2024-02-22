package core.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LC 349. Intersection of Two Arrays
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        List<Integer> res = new ArrayList<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                res.add(i);
                set.remove(i);
            }
        }
        int[] r = new int[res.size()];
        int i = 0;
        for (int n : res) {
            r[i++] = n;
        }
        return r;
    }
    // TS: O(N)
}

package core.array;

import java.util.HashSet;
import java.util.Set;

/**
 * LC 2956. Find Common Elements Between Two Arrays
 */
public class FindCommonElementsBetweenTwoArrays {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        int c1 = 0, c2 = 0;
        for (int i : nums1) {
            if (set2.contains(i)) {
                c1++;
            }
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                c2++;
            }
        }
        return new int[]{c1, c2};
    }
    // TS: O(N)
}

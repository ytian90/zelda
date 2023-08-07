package core.sorting;

import java.util.HashSet;
import java.util.Set;

/**
 * LC 128. Longest Consecutive Sequence
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int res = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int next = n + 1;
                while (set.contains(next)) {
                    next++;
                }
                res = Math.max(res, next - n);
            }
        }
        return res;
    }
    // TS: O(N)
}

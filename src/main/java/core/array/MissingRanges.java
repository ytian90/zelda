package core.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC 163. Missing Ranges
 */
public class MissingRanges {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        int prev = lower;
        for (int i : nums) {
            if (i - prev > 0) {
                res.add(Arrays.asList(prev, i - 1));
            }
            prev = i + 1;
        }
        if (prev <= upper) {
            res.add(Arrays.asList(prev, upper));
        }
        return res;
    }
    // TS: O(N)
}

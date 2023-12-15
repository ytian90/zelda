package core.array.twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC 1570. Dot Product of Two Sparse Vectors
 */
public class DotProductOfTwoSparseVectors {
    // solution 1: Brutal force
    int[] nums;
    // solution 2: Map the index to value for non-zero values
    Map<Integer, Integer> map;
    // solution 3: [index, value]
    List<int[]> pairs;

    DotProductOfTwoSparseVectors(int[] nums) {
        // solution 1
        this.nums = nums;
        // solution 2
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
        // solution 3
        pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                pairs.add(new int[]{i, nums[i]});
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(DotProductOfTwoSparseVectors vec) {
        if (this.nums.length != vec.nums.length) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += this.nums[i] * vec.nums[i];
        }
        return res;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct2(DotProductOfTwoSparseVectors vec) {
        int res = 0;
        for (Integer i : this.map.keySet()) {
            if (vec.map.containsKey(i)) {
                res += this.map.get(i) * vec.map.get(i);
            }
        }
        return res;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct3(DotProductOfTwoSparseVectors vec) {
        int res = 0, p = 0, q = 0;
        while (p < pairs.size() && q < vec.pairs.size()) {
            if (pairs.get(p)[0] == pairs.get(q)[0]) {
                res += pairs.get(p)[1] * pairs.get(q)[1];
                p++;
                q++;
            } else if (pairs.get(p)[0] < vec.pairs.get(q)[0]) {
                p++;
            } else {
                q++;
            }
        }
        return res;
    }

}

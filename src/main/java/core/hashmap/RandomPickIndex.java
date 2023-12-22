package core.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC 398. Random Pick Index
 */
public class RandomPickIndex {
    Map<Integer, List<Integer>> map = new HashMap<>();

    public RandomPickIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }
    // TS: O(N)

    public int pick(int target) {
        if (!map.containsKey(target)) {
            return -1;
        }
        int pos = (int) (map.get(target).size() * Math.random());
        return map.get(target).get(pos);
    }
    // TS: O(1)
}

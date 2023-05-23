package core.design;

import java.util.*;

/**
 * LC 380. Insert Delete GetRandom O(1)
 */
public class InsertDeleteGetRandomO1 {
    // Internal variables: List(store values), map<value, location in List>, random
    // Insert: check exist, update list and map
    // Remove: check exist, get val's loc, put last value to loc, remove last position/val
    // Random: random nextInt the size of list

    List<Integer> nums;
    Map<Integer, Integer> locations;
    Random random;

    public InsertDeleteGetRandomO1() {
        this.nums = new LinkedList<>();
        this.locations = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (locations.containsKey(val)) {
            return false;
        }
        locations.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!locations.containsKey(val)) {
            return false;
        }
        int loc = locations.get(val);
        if (loc < nums.size() - 1) {
            int lastVal = nums.get(nums.size() - 1);
            nums.set(loc, lastVal);
            locations.put(lastVal, loc);
        }
        nums.remove(nums.size() - 1);
        locations.remove(val);
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
    // T: O(1)
    // S: O(N)
}

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

class InsertDeleteGetRandomO1_Duplicate {
    List<Integer> nums;
    Map<Integer, List<Integer>> locations; // key - number value, value - location
    Random random;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1_Duplicate() {
        this.nums = new ArrayList<>();
        this.locations = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (!locations.containsKey(val)) {
            locations.put(val, new ArrayList<>());
        }
        locations.get(val).add(nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!locations.containsKey(val)) {
            return false;
        }
        List<Integer> list = locations.get(val);
        int loc = list.get(list.size() - 1);
        if (loc < nums.size() - 1) {
            int lastVal = nums.get(nums.size() - 1);
            nums.set(loc, lastVal);
            int size = locations.get(lastVal).size();
            locations.get(lastVal).remove(size - 1);
            locations.get(lastVal).add(loc);
        }
        nums.remove(nums.size() - 1);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }

    public static void main(String[] args) {
        InsertDeleteGetRandomO1_Duplicate obj = new InsertDeleteGetRandomO1_Duplicate();
        obj.insert(2);
        obj.insert(3);
        obj.insert(2);
        obj.insert(3);
        System.out.println(obj.getRandom());
        obj.remove(2);
        System.out.println(obj.getRandom());
    }
}

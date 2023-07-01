package core.design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * LC 460. LFU Cache
 */
public class LFUCache {
    // <Key, Value>
    Map<Integer, Integer> values;
    // <Key, Frequency>
    Map<Integer, Integer> counts;
    // <Frequency, Keys with same Frequency>
    Map<Integer, LinkedHashSet<Integer>> lists;
    int capacity;
    int min;

    public LFUCache(int capacity) {
        this.values = new HashMap<>();
        this.counts = new HashMap<>();
        this.lists = new HashMap<>();
        this.capacity = capacity;
        this.min = -1;
    }

    // T: O(1)
    public int get(int key) {
        if (!values.containsKey(key)) {
            return -1;
        }
        update(key);
        return values.get(key);
    }

    private void update(int key) {
        int count = counts.get(key);
        counts.put(key, count + 1);
        lists.get(count).remove(key);
        if (count == min && lists.get(count).size() == 0) {
            min++;
        }
        lists.putIfAbsent(count + 1, new LinkedHashSet<>());
        lists.get(count + 1).add(key);
    }

    // T: O(1)
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (values.containsKey(key)) {
            values.put(key, value);
            update(key);
            return;
        }
        if (values.size() == capacity) {
            int minKey = lists.get(min).iterator().next();
            values.remove(minKey);
            counts.remove(minKey);
            lists.get(min).remove(minKey);
        }
        values.put(key, value);
        counts.put(key, 1);
        lists.putIfAbsent(1, new LinkedHashSet<>());
        lists.get(1).add(key);
        min = 1;
    }

}

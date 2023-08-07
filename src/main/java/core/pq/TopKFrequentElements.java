package core.pq;

import java.util.*;

/**
 * LC 347. Top K Frequent Elements
 */
public class TopKFrequentElements {
    // PriorityQueue
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        if (k == nums.length) {
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (map.get(a) - map.get(b)));
        for (int n : map.keySet()) {
            pq.add(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        return res;
    }
    // T: O(N * logK)
    // S: O(N + K)

    // TreeMap
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for (int n : map.keySet()) {
            int freq = map.get(n);
            if (!freqMap.containsKey(freq)) {
                freqMap.put(freq, new ArrayList<>());
            }
            freqMap.get(freq).add(n);
        }
        int[] res = new int[k];
        int j = 0;
        while (j < k) {
            for (int i : freqMap.pollLastEntry().getValue()) {
                res[j++] = i;
            }
        }
        return res;
    }
    // T: O(N * logN)
    // S: O(N + K)

    // Bucket
    public int[] topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int n : map.keySet()) {
            int freq = map.get(n);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<>();
            }
            bucket[freq].add(n);
        }
        int[] res = new int[k];
        int j = 0;
        for (int i = bucket.length - 1; i > 0 && k > 0; i--) {
            if (bucket[i] != null) {
                List<Integer> l = bucket[i];
                for (int a : l) {
                    res[j++] = a;
                }
                k -= l.size();
            }
        }
        return res;
    }
    // TS: O(N)

}

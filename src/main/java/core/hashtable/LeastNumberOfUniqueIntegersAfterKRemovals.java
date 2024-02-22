package core.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LC 1481. Least Number of Unique Integers after K Removals
 */
public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(map.values());
        int elementRemoved = 0;
        while (!pq.isEmpty()) {
            elementRemoved += pq.peek();
            if (elementRemoved > k) {
                return pq.size();
            }
            pq.poll();
        }
        return 0;
    }
    // T: O(N * logN)
    // S: O(N)

    public static int findLeastNumOfUniqueInts2(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int n = arr.length;
        int[] count = new int[n + 1];
        for (int c : map.values()) {
            count[c]++;
        }
        int remainUnique = map.size();
        for (int i = 1; i <= n; i++) {
            int numElementsToRemove = Math.min(k / i, count[i]);
            k -= i * numElementsToRemove;
            remainUnique -= numElementsToRemove;
            if (k < i) {
                return remainUnique;
            }
        }
        return 0;
    }
    // TS: O(N)

    public static void main(String[] args) {
        System.out.println(findLeastNumOfUniqueInts2(new int[]{4,3,1,1,3,3,2}, 3));
    }
}

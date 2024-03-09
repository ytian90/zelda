package core.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 3005. Count Elements With Maximum Frequency
 */
public class CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0, totalFreq = 0;
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
            int f = freq.get(n);
            if (f > maxFreq) {
                maxFreq = f;
                totalFreq = f;
            } else if (f == maxFreq) {
                totalFreq += f;
            }
        }
        return totalFreq;
    }
    // TS: O(N)
}

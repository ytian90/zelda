package core.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 763. Partition Labels
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int start = 0, last = 0;
        for (int i = 0; i < s.length(); i++) {
            last = Math.max(last, lastIndex[s.charAt(i) - 'a']);
            if (i == last) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
    // T: O(N)
    // S: O(N)
}

package core.slidingwindow;

import java.util.List;
import java.util.PriorityQueue;

/**
 * LC 632. Smallest Range Covering Elements from K Lists
 */
public class SmallestRangeCoveringElementsFromKLists {
    class Pair {
        int row;
        int col;
        int val;

        Pair(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            max = Math.max(max, val);
            pq.add(new Pair(i, 0, val));
        }
        int[] res = new int[2];
        int range = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (max - curr.val < range) {
                res[0] = curr.val;
                res[1] = max;
                range = max - curr.val;
            }
            if (curr.col + 1 < nums.get(curr.row).size()) {
                int val = nums.get(curr.row).get(curr.col + 1);
                max = Math.max(max, val);
                pq.add(new Pair(curr.row, curr.col + 1, val));
            } else {
                break; // one list is completed
            }
        }
        return res;
    }
    // T: O(N * logM), where N is the total number of elements in all the lists, and m is the total number of lists
    // S: O(M)
}

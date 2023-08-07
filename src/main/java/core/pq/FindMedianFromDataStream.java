package core.pq;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LC 295. Find Median from Data Stream
 */
public class FindMedianFromDataStream {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    private boolean even;

    public FindMedianFromDataStream() {
        this.small = new PriorityQueue<>(Collections.reverseOrder());
        this.large = new PriorityQueue<>();
        this.even = true;
    }

    public void addNum(int num) {
        if (even) {
            large.add(num);
            small.add(large.poll());
        } else {
            small.add(num);
            large.add(small.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (even) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return small.peek();
        }
    }
    // T: addNum O(logN) findMedian O(1)
    // S: O(N)
}

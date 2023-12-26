package core.slidingwindow;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * LC 480. Sliding Window Median
 */
public class SlidingWindowMedian {
    TreeSet<Integer> left;
    TreeSet<Integer> right;

    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) ->
                (nums[a] != nums[b]) ? Integer.compare(nums[a], nums[b]) : a - b;
        left = new TreeSet<>(comparator.reversed());
        right = new TreeSet<>(comparator);
        int n = nums.length;
        double[] res = new double[n - k + 1];
        for (int i = 0; i < k; i++) {
            left.add(i);
        }
        balance();
        res[0] = getMedian(nums, k);
        int index = 1;
        for (int i = k; i < n; i++) {
            if (!left.remove(i - k)) {
                right.remove(i - k);
            }
            right.add(i);
            left.add(right.pollFirst());
            balance();
            res[index++] = getMedian(nums, k);
        }
        return res;
    }
    // T: O(N * logK)
    // S: O(N)

    private void balance() {
        while (left.size() > right.size()) {
            right.add(left.pollFirst());
        }
    }

    private double getMedian(int[] nums, int k) {
        if (k % 2 == 0) {
            return ((double) nums[left.first()] + nums[right.first()]) / 2;
        } else {
            return nums[right.first()];
        }
    }


    // Custom Priority Queue
    public double[] medianSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        double[] res = new double[n - k + 1];
        CustomPriorityQueue pq = new CustomPriorityQueue();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() == k) {
                res[index++] = pq.getMedian();
                pq.remove(nums[i - k + 1]);
            }
        }
        return res;
    }

    class CustomPriorityQueue {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        public void add(int num) {
            minPQ.add(num);
            maxPQ.add(minPQ.poll());
            if (maxPQ.size() > minPQ.size()) {
                minPQ.add(maxPQ.poll());
            }
        }

        public double getMedian() {
            if (minPQ.size() > maxPQ.size()) {
                return minPQ.peek();
            } else {
                return ((double) minPQ.peek() + maxPQ.peek()) / 2;
            }
        }

        public int size() {
            return minPQ.size() + maxPQ.size();
        }

        public boolean remove(int x) {
            return minPQ.remove(x) || maxPQ.remove(x);
        }
    }
    // T: O(N * logK)
    // S: O(N)

}

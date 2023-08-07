package core.sorting;

import java.util.*;

/**
 * LC 215. Kth Largest Element in an Array
 */
public class KthLargestElementInAnArray {
    // Priority Queue
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
    // T: O(N * logK)
    // S: O(K)

    // Quick Select in-place
    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, k, 0, nums.length - 1);
    }

    private int helper(int[] nums, int k, int lo, int hi) {
        int i = lo, pivot = nums[hi];
        for (int j = lo; j < hi; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, hi);
        int count = hi - i + 1;
        if (count == k) {
            return nums[i];
        }
        if (count > k) {
            return helper(nums, k, i + 1, hi);
        } else {
            return helper(nums, k - count, lo, i - 1);
        }
    }

    private void swap(int[] n, int i, int j) {
        int t = n[i];
        n[i] = n[j];
        n[j] = t;
    }
    // T: O(N) in average, O(N ^ 2) in the worst case
    // S: O(1)

    // Quick Select
    public int findKthLargest3(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
        return quickSelect(list, k);
    }

    private int quickSelect(List<Integer> nums, int k) {
        int pivotIndex = new Random().nextInt(nums.size());
        int pivot = nums.get(pivotIndex);
        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int n : nums) {
            if (n > pivot) {
                left.add(n);
            } else if (n < pivot) {
                right.add(n);
            } else {
                mid.add(n);
            }
        }
        if (left.size() >= k) {
            return quickSelect(left, k);
        }
        if (left.size() + mid.size() < k) {
            return quickSelect(right, k - left.size() - mid.size());
        }
        return pivot;
    }
    // T: O(N) in average, O(N ^ 2) in the worst case
    // S: O(N)
}

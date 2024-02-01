package core.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * LC 1944. Number of Visible People in a Queue
 */
public class NumberOfVisiblePeopleInAQueue {
    public static int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                stack.pop();
                res[i]++;
            }
            if (!stack.isEmpty()) {
                res[i]++;
            }
            stack.push(heights[i]);
        }
        return res;
    }
    // TS: O(N)

    // TLE
    public static int[] canSeePersonsCount2(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int count = countRight(heights, i);
            res[i] = count;
        }
        return res;
    }

    private static int countRight(int[] nums, int start) {
        Deque<Integer> stack = new ArrayDeque<>();
        int height = nums[start], n = nums.length;
        for (int i = start + 1; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(nums[i]);
            } else if (stack.peek() < nums[i]) {
                stack.push(nums[i]);
            }
            if (nums[i] >= height) {
                break;
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(canSeePersonsCount(new int[]{10,6,8,5,11,9})));
    }
}

package core.stack;

import java.util.Stack;

/**
 * LC 84. Largest Rectangle in Histogram
 */
public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                max = Math.max(max, heights[stack.pop()] * (i - 1 - stack.peek()));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (heights.length - 1 - stack.peek()));
        }
        return max;
    }
    // Time/Space: O(N)

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}

package core.array.twopointers;

/**
 * LC 11. Container with Most Water
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length, left = 0, right = n - 1, res = 0;
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
    // T: O(N)
    // S: O(1)
}

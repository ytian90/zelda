package core.array.twopointers;

/**
 * LC 42. Trapping Rain Water
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length, left = 0, right = n - 1;
        int lmh = 0, rmh = 0, res = 0;
        while (left < right) {
            lmh = Math.max(lmh, height[left]);
            rmh = Math.max(rmh, height[right]);
            if (height[left] < height[right]) {
                res += lmh - height[left];
                left++;
            } else {
                res += rmh - height[right];
                right--;
            }
        }
        return res;
    }
    // T: O(N)
    // S: O(1)
}

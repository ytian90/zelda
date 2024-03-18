package core.greedy;

/**
 * LC 605. Can Place Flowers
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0, len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                int left = (i > 0) ? flowerbed[i - 1] : 0;
                int right = (i < len - 1) ? flowerbed[i + 1] : 0;
                if (left == 0 && right == 0) {
                    flowerbed[i] = 1;
                    count++;
                    if (count > n) {
                        return true;
                    }
                }
            }
        }
        return count == n;
    }
    // T: O(N)
    // S: O(1)
}
